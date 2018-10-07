package in.indigenous.sso.security.filter;

import java.io.IOException;
import java.util.Date;
import java.util.stream.Collectors;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import in.indigenous.sso.security.auth.SSOAuthenticationToken;
import in.indigenous.sso.security.config.JWTConfig;
import in.indigenous.sso.security.dto.UserCredentialsDTO;
import in.indigenous.sso.security.exception.SSOSecurityRequestParseException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class SSOAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

	private ObjectMapper mapper = new ObjectMapper();

	private final JWTConfig jwtConfig;

	public SSOAuthenticationFilter(JWTConfig jwtConfig) {
		this.jwtConfig = jwtConfig;
		this.setRequiresAuthenticationRequestMatcher(new AntPathRequestMatcher(jwtConfig.getUri(), "POST"));
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) {
			try {
				UserCredentialsDTO credentials = getCredentials(request);
				SSOAuthenticationToken authToken = getAuthToken(credentials.getDomain(), credentials.getSubDomain(),
						credentials.getApplication(), credentials.getEmail(), credentials.getPassword());

				return this.getAuthenticationManager().authenticate(authToken);
			} catch (SSOSecurityRequestParseException e) {
				throw new AuthenticationServiceException("SSO Security: Exception occured when attempting authentication.", e);
			}
	}

	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication auth) throws IOException, ServletException {
		Long now = System.currentTimeMillis();
		String token = Jwts.builder().setSubject(auth.getName())
				.claim("authorities",
						auth.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
				.setIssuedAt(new Date(now)).setExpiration(new Date(now + jwtConfig.getExpiration() * 1000)) // in
																											// milliseconds
				.signWith(SignatureAlgorithm.HS512, jwtConfig.getSecret().getBytes()).compact();
		// Add token to header
		response.addHeader(jwtConfig.getHeader(), jwtConfig.getPrefix() + token);
	}

	private UserCredentialsDTO getCredentials(HttpServletRequest request) throws SSOSecurityRequestParseException {
		try {
			return mapper.readValue(request.getInputStream(), UserCredentialsDTO.class);
		} catch (JsonParseException e) {
			throw new SSOSecurityRequestParseException("SSO Security: Could not parse http request body into json.", e);
		} catch (JsonMappingException e) {
			throw new SSOSecurityRequestParseException("SSO Security: Could not map http request body into json.", e);
		} catch (IOException e) {
			throw new SSOSecurityRequestParseException(
					"SSO Security: Could not parse http request body due to io exception.", e);
		}
	}

	private SSOAuthenticationToken getAuthToken(String domain, String subDomain, String application, String email,
			String password) {
		return new SSOAuthenticationToken(email, password, domain, subDomain, application);
	}

}
