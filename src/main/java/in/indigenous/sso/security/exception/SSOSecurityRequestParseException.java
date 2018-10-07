package in.indigenous.sso.security.exception;

public class SSOSecurityRequestParseException extends SSOSecurityException {

	/**
	 * Generated Serial version UId.
	 */
	private static final long serialVersionUID = 912685117832524001L;

	public SSOSecurityRequestParseException() {
		super();
	}

	public SSOSecurityRequestParseException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public SSOSecurityRequestParseException(String message, Throwable cause) {
		super(message, cause);
	}

	public SSOSecurityRequestParseException(String message) {
		super(message);
	}

	public SSOSecurityRequestParseException(Throwable cause) {
		super(cause);
	}

}
