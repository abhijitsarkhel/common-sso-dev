package in.indigenous.sso.security.dto;

import java.io.Serializable;

public class ApplicationDTO implements Serializable {

	/**
	 * Generated serial version uid.
	 */
	private static final long serialVersionUID = -4739852558841137643L;

	private String domain;

	private String subDomain;

	private String application;

	private String email;

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public String getSubDomain() {
		return subDomain;
	}

	public void setSubDomain(String subDomain) {
		this.subDomain = subDomain;
	}

	public String getApplication() {
		return application;
	}

	public void setApplication(String application) {
		this.application = application;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
