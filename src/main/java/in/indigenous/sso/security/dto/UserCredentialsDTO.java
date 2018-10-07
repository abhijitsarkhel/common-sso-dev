package in.indigenous.sso.security.dto;

import java.io.Serializable;

public class UserCredentialsDTO implements Serializable {

	/**
	 * Generated serial version UId.
	 */
	private static final long serialVersionUID = 1719312889039095469L;

	private String domain;

	private String subDomain;

	private String application;

	private String email;
	
	private String password;
	
	public UserCredentialsDTO() {
		
	}

	public UserCredentialsDTO(String domain, String subDomain, String application, String email, String password) {
		super();
		this.domain = domain;
		this.subDomain = subDomain;
		this.application = application;
		this.email = email;
		this.password = password;
	}

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
