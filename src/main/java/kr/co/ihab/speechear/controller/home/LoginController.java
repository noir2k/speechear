package kr.co.ihab.speechear.controller.home;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import kr.co.ihab.speechear.dto.security.UserDto;
import kr.co.ihab.speechear.service.security.UserService;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class LoginController {
//    private final UserService userService;

    @GetMapping(value = {"/","/login"})
    public String login(HttpServletRequest request) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
            return "home/Login.html";
        }
        else {
            return "home/FunctionSelect.html";
        }
    }

    @GetMapping("/signUp")
	public String signUp(Model model) {
		model.addAttribute("userDto", new UserDto());
		return "home/SignUp";
	}
 
	@PostMapping("/signUp")
	public String signUp(@ModelAttribute("userDto") UserDto userDto) {
//		userService.insert(userDto);
		return "redirect:/login";
	}
}
