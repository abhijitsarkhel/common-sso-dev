package in.indigenous.sso.security.filter;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import in.indigenous.sso.security.auth.SSOAuthenticationToken;
import in.indigenous.sso.security.config.JWTConfig;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

public class JwtTokenAuthenticationFilter extends  OncePerRequestFilter {
	
	private final JWTConfig jwtConfig;
	
	public JwtTokenAuthenticationFilter(JWTConfig jwtConfig) {
		this.jwtConfig = jwtConfig;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

				String header = request.getHeader(jwtConfig.getHeader());
				if(header == null || !header.startsWith(jwtConfig.getPrefix())) {
					filterChain.doFilter(request, response);
					return;
				}
				String token = header.replace(jwtConfig.getPrefix(), "");
				try {
					Claims claims = Jwts.parser()
							.setSigningKey(jwtConfig.getSecret().getBytes())
							.parseClaimsJws(token)
							.getBody();
					
					String username = claims.getSubject();
					if(username != null) {
						@SuppressWarnings("unchecked")
						List<String> authorities = (List<String>) claims.get("authorities");
						SSOAuthenticationToken auth = new SSOAuthenticationToken(
										 username, null, authorities.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList()));
						 SecurityContextHolder.getContext().setAuthentication(auth);
					}
				} catch (Exception e) {
					SecurityContextHolder.clearContext();
				}
				filterChain.doFilter(request, response);
	}

}
