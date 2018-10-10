package in.indigenous.sso.security.dto;

import java.io.Serializable;

public class UserDTO implements Serializable {

	/**
	 * Generated Serial version UId.
	 */
	private static final long serialVersionUID = -1224514662522167553L;

	private String domain;

	private String subDomain;

	private String application;

	private String userName;

	public UserDTO() {

	}

	public UserDTO(String domain, String subDomain, String application, String userName) {
		super();
		this.domain = domain;
		this.subDomain = subDomain;
		this.application = application;
		this.userName = userName;
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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}
