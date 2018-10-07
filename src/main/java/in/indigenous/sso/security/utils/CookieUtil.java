package in.indigenous.sso.security.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.util.WebUtils;

public final class CookieUtil implements Cloneable {
	
	private CookieUtil() {
		// No Instantiation
	}

	public static final void create(HttpServletResponse httpServletResponse, String name, String value, Boolean secure,
			Integer maxAge, String domain) {
		Cookie cookie = new Cookie(name, value);
		cookie.setSecure(secure);
		//cookie.setHttpOnly(true);
		cookie.setMaxAge(maxAge);
		cookie.setDomain(domain);
		cookie.setPath("/");
		httpServletResponse.addCookie(cookie);
	}
	
	public static final void clear(HttpServletResponse httpServletResponse, String name) {
        Cookie cookie = new Cookie(name, null);
        cookie.setPath("/");
        //cookie.setHttpOnly(true);
        cookie.setMaxAge(0);
        httpServletResponse.addCookie(cookie);
    }

    public static final String getValue(HttpServletRequest httpServletRequest, String name) {
        Cookie cookie = WebUtils.getCookie(httpServletRequest, name);
        return cookie != null ? cookie.getValue() : null;
    }
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}
}
