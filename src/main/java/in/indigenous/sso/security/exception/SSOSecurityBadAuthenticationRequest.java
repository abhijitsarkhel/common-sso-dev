package in.indigenous.sso.security.exception;

import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;

public class SSOSecurityBadAuthenticationRequest extends AuthenticationCredentialsNotFoundException {

	/**
	 * Generated Serial version UId.
	 */
	private static final long serialVersionUID = -8102143134376277827L;

	public SSOSecurityBadAuthenticationRequest(String msg, Throwable t) {
		super(msg, t);
	}

	public SSOSecurityBadAuthenticationRequest(String msg) {
		super(msg);
	}

}
