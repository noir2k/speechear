package kr.co.ihab.speechear.api.controller.function;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Function4DController {
//    @Autowired
//    private UserService uservice;
    
    @RequestMapping(value = "/function/Function4D")
    public String home(Authentication authentication, Model model)
    {
//        List<String> memberInfo = new ArrayList<String>();
//        memberInfo.add(uservice.getMemberInfo(authentication.getName()).getName());
//        memberInfo.add(uservice.getMemberInfo(authentication.getName()).getCellphone());
//        model.addAttribute("member", memberInfo);
        
        return "function/Function4D.html";
    }
}
