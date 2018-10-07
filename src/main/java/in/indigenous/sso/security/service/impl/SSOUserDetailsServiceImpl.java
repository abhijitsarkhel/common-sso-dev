package in.indigenous.sso.security.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import in.indigenous.sso.security.auth.SSOUserDetails;
import in.indigenous.sso.security.dto.SSOUser;
import in.indigenous.sso.security.dto.UserDTO;
import in.indigenous.sso.security.exception.SSOSecurityBadAuthenticationRequest;
import in.indigenous.sso.security.gateway.SSOServiceGateway;
import in.indigenous.sso.security.service.SSOUserDetailsService;

@Service("ssoUserDetailsService")
public class SSOUserDetailsServiceImpl implements SSOUserDetailsService {

	@Autowired
	private SSOServiceGateway ssoServiceGateway;

	@Override
	public UserDetails loadCustomUser(String username, String domain, String subDomain, String application) {
		if (StringUtils.isEmpty(domain)) {
			throw new SSOSecurityBadAuthenticationRequest("SSO Security: Bad request, domain is a mandatory field.");
		}
		if ((StringUtils.isEmpty(subDomain) && StringUtils.isNotEmpty(application))
				|| (StringUtils.isNotEmpty(subDomain) && StringUtils.isEmpty(application))) {
			throw new SSOSecurityBadAuthenticationRequest(
					"SSO Security: Bad request, either both sub-domain and application should be present or none.");
		}
		return prepareResponse(
				ssoServiceGateway.getUserDetails(prepareRequest(domain, subDomain, application, username)));
	}

	private UserDTO prepareRequest(String domain, String subDomain, String application, String username) {
		return new UserDTO(domain, subDomain, application, username);
	}

	private SSOUserDetails prepareResponse(SSOUser dto) {
		// TODO - handle password and authorities.
		return new SSOUserDetails(null, dto.getEmail(), dto.isEnabled());
	}

}
