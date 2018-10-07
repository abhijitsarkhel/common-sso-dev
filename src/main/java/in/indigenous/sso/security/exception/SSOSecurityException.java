package in.indigenous.sso.security.exception;

public class SSOSecurityException extends Exception {

	/**
	 * Generated Serial version UId.
	 */
	private static final long serialVersionUID = -1432383381793035736L;

	public SSOSecurityException() {
		super();
	}

	public SSOSecurityException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public SSOSecurityException(String message, Throwable cause) {
		super(message, cause);
	}

	public SSOSecurityException(String message) {
		super(message);
	}

	public SSOSecurityException(Throwable cause) {
		super(cause);
	}

}
