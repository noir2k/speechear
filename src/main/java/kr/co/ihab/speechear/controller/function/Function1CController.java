package kr.co.ihab.speechear.controller.function;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.ihab.speechear.service.security.UserService;

@Controller
public class Function1CController {
//    @Autowired
//    private UserService uservice;
    
    @RequestMapping(value = "/function/Function1C")
    public String home(Authentication authentication, Model model)
    {
        List<String> memberInfo = new ArrayList<String>();
//        memberInfo.add(uservice.getMemberInfo(authentication.getName()).getName());
//        memberInfo.add(uservice.getMemberInfo(authentication.getName()).getCellphone());
        model.addAttribute("member", memberInfo);
        
        return "function/Function1C.html";
    }
}