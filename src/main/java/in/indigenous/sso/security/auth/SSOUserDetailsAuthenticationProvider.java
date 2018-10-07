package in.indigenous.sso.security.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;

import in.indigenous.sso.security.service.SSOUserDetailsService;

public class SSOUserDetailsAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {

	@Autowired
	private SSOUserDetailsService userDetailsService;

	@Override
	protected void additionalAuthenticationChecks(UserDetails userDetails,
			UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
		// TODO - No Implementation
	}

	@Override
	protected UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken authentication)
			throws AuthenticationException {
		SSOAuthenticationToken token = (SSOAuthenticationToken) authentication;
		UserDetails loadedUser = null;
		loadedUser = this.userDetailsService.loadCustomUser(username, token.getDomain(), token.getSubDomain(),
				token.getApplication());
		return loadedUser;
	}

}
