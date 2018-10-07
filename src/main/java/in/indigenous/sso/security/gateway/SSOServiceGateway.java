package in.indigenous.sso.security.gateway;

import in.indigenous.sso.security.dto.SSOUser;
import in.indigenous.sso.security.dto.UserDTO;

public interface SSOServiceGateway {

	SSOUser getUserDetails(UserDTO credentials);
}
