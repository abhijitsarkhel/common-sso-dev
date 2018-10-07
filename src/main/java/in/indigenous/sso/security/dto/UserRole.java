package in.indigenous.sso.security.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import in.indigenous.sso.security.constants.ApplicationType;


public class UserRole implements Serializable {

	/**
	 * Generated Serial version UId.
	 */
	private static final long serialVersionUID = 6471317757590943970L;

	private String domain;

	private String subDomain;

	private String email;

	private ApplicationType type;

	private String application;

	private Map<String, List<Map<String, List<String>>>> appRoles;

	private String role;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public ApplicationType getType() {
		return type;
	}

	public void setType(ApplicationType type) {
		this.type = type;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public Map<String, List<Map<String, List<String>>>> getAppRoles() {
		return appRoles;
	}

	public void setAppRoles(Map<String, List<Map<String, List<String>>>> appRoles) {
		this.appRoles = appRoles;
	}

	public String getApplication() {
		return application;
	}

	public void setApplication(String application) {
		this.application = application;
	}

	public String getSubDomain() {
		return subDomain;
	}

	public void setSubDomain(String subDomain) {
		this.subDomain = subDomain;
	}

}
