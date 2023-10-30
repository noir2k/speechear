package kr.co.ihab.speechear.api.controller.system;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SystemController {
    @GetMapping("/AccessDenied")
	public String accessDenied() {
		return "system/AccessDenied.html";
	}
}
