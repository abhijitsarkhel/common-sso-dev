package in.indigenous.sso.security.dto;

import java.io.Serializable;

public class UserDTO implements Serializable {

	/**
	 * Generated Serial version UId.
	 */
	private static final long serialVersionUID = -1224514662522167553L;

	private String donmain;

	private String subDomain;

	private String application;

	private String userName;

	public UserDTO() {

	}

	public UserDTO(String donmain, String subDomain, String application, String userName) {
		super();
		this.donmain = donmain;
		this.subDomain = subDomain;
		this.application = application;
		this.userName = userName;
	}

	public String getDonmain() {
		return donmain;
	}

	public void setDonmain(String donmain) {
		this.donmain = donmain;
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
