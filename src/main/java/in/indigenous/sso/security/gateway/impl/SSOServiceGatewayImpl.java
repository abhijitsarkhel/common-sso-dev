package in.indigenous.sso.security.gateway.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import in.indigenous.sso.security.dto.SSOUser;
import in.indigenous.sso.security.dto.UserDTO;
import in.indigenous.sso.security.gateway.SSOServiceGateway;

public class SSOServiceGatewayImpl implements SSOServiceGateway {
	
	@Autowired
	private RestTemplate restTemplate;
	
	private String ssoServiceGateway;

	@Override
	public SSOUser getUserDetails(UserDTO dto) {
		UriComponents uriComponents = UriComponentsBuilder.newInstance()
			      .scheme("http").host(ssoServiceGateway).path("/junit-5").build();
		return restTemplate.postForEntity(uriComponents.toUriString(), dto, SSOUser.class).getBody();
	}

}
