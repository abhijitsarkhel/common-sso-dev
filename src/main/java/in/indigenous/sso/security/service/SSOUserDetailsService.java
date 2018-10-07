package in.indigenous.sso.security.service;

import org.springframework.security.core.userdetails.UserDetails;

public interface SSOUserDetailsService {

	UserDetails loadCustomUser(String username, String domain, String subDomain, String application);
}
