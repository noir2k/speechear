package kr.co.ihab.speechear.component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Log4j2
@Component
public class UserLogComponent {

    public String getAccess_URI() {
        String uri = null;
		ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		HttpServletRequest request = sra.getRequest();
        uri = request.getRequestURI();

        return uri;
    }

    public String getAccess_ip() {
		String ip_addr = null;
		ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		HttpServletRequest request = sra.getRequest();
		
		ip_addr = request.getHeader("X-Forwarded-For");
		if (ip_addr == null) {
			ip_addr = request.getHeader("Proxy-Client-IP");
		}
		if (ip_addr == null) {
			ip_addr = request.getHeader("WL-Proxy-Client-IP"); 
	    }
		if (ip_addr == null) {
			ip_addr = request.getHeader("HTTP_CLIENT_IP");
	    }
		if (ip_addr == null) {
			ip_addr = request.getHeader("HTTP_X_FORWARDED_FOR");
	    }
		if (ip_addr == null) {
			ip_addr = request.getRemoteAddr();
	    }

//        log.debug("ip_addr");
        ip_addr = ip_addr.trim().split(",")[0];
		return ip_addr;
	}
	
	public String getAccess_Time() {
		TimeZone zone = TimeZone.getTimeZone("Asia/Seoul");
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		format.setTimeZone(zone);
		String currentTime = format.format(System.currentTimeMillis());
		return currentTime;
	}

	public String getAccess_Id(){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal(); 
        UserDetails userDetails = (UserDetails)principal;
        return userDetails.getUsername();
	}

    public String getAccess_role() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal(); 
        UserDetails userDetails = (UserDetails)principal;
        return userDetails.getAuthorities().toString();
    }
}
