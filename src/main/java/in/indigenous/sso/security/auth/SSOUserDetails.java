package in.indigenous.sso.security.auth;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class SSOUserDetails implements UserDetails {
	
	/**
	 * Generated Serial version UId.
	 */
	private static final long serialVersionUID = -8002358053632660835L;

	private String password;
	
	private String userName;
	
	private boolean enabled;
	
	public SSOUserDetails() {
		
	}

	public SSOUserDetails(String password, String userName, boolean enabled) {
		super();
		this.password = password;
		this.userName = userName;
		this.enabled = enabled;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO - implement authorities
		return null;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return userName;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO - Not implemented
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO - Not implemented
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO - Not implemented
		return true;
	}

	@Override
	public boolean isEnabled() {
		return enabled;
	}

}
