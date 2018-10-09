package in.indigenous.sso.security.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class SSOUser implements Serializable {

	/**
	 * Generated Serial version UId.
	 */
	private static final long serialVersionUID = -6427971975858371020L;

	private String email;

	private String domain;

	private boolean enabled;

	private List<String> subDomains;

	private List<Map<String, List<String>>> apps;

	private List<String> domainRoles;

	private List<Map<String, List<String>>> appRoles;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public List<String> getSubDomains() {
		return subDomains;
	}

	public void setSubDomains(List<String> subDomains) {
		this.subDomains = subDomains;
	}

	public List<Map<String, List<String>>> getApps() {
		return apps;
	}

	public void setApps(List<Map<String, List<String>>> apps) {
		this.apps = apps;
	}

	public List<String> getDomainRoles() {
		return domainRoles;
	}

	public void setDomainRoles(List<String> domainRoles) {
		this.domainRoles = domainRoles;
	}

	public List<Map<String, List<String>>> getAppRoles() {
		return appRoles;
	}

	public void setAppRoles(List<Map<String, List<String>>> appRoles) {
		this.appRoles = appRoles;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

}
