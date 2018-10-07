package in.indigenous.sso.security.auth;

import java.util.Collection;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

public class SSOAuthenticationToken extends UsernamePasswordAuthenticationToken {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7866393699644847209L;

	private String domain;
	
	private String subDomain;
	
	private String application;
	
	public SSOAuthenticationToken(Object principal, Object credentials) {
		super(principal, credentials);
	}
	
	public SSOAuthenticationToken(Object principal, Object credentials,
			Collection<? extends GrantedAuthority> authorities) {
		super(principal, credentials, authorities);
	}
	
	public SSOAuthenticationToken(Object principal, Object credentials, String domain, String subDomain,
			String application) {
		super(principal, credentials);
		this.domain = domain;
		this.subDomain = subDomain;
		this.application = application;
	}
	
	public SSOAuthenticationToken(Object principal, Object credentials, String domain, String subDomain,
			String application, Collection<? extends GrantedAuthority> authorities) {
		super(principal, credentials, authorities);
		this.domain = domain;
		this.subDomain = subDomain;
		this.application = application;
	}

	public String getDomain() {
		return domain;
	}

	public String getSubDomain() {
		return subDomain;
	}

	public String getApplication() {
		return application;
	}
}
