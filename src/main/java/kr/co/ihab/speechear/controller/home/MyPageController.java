package kr.co.ihab.speechear.controller.home;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.ihab.speechear.dto.home.UserSettingDto;
import kr.co.ihab.speechear.service.home.UserSettingService;
import kr.co.ihab.speechear.service.security.UserService;

@Controller
public class MyPageController {
//    @Autowired
//    private UserService service;
//
//    @Autowired
//    private UserSettingService usservice;
    
    @RequestMapping(value = "/home/MyPage")
    public String home(Authentication authentication, Model model)
    {
//        List<String> memberInfo = new ArrayList<String>();
//        memberInfo.add(authentication.getName());
//        memberInfo.add(service.getMemberInfo(authentication.getName()).getName());
//        memberInfo.add(service.getMemberInfo(authentication.getName()).getCellphone());
//        memberInfo.add(service.getMemberInfo(authentication.getName()).getEmail());
//        model.addAttribute("member", memberInfo);
//
//        model.addAttribute("noiseType",usservice.getUS(authentication.getName()).getNoise_type());
//        model.addAttribute("playSpeed",usservice.getUS(authentication.getName()).getPlay_speed());

        return "home/MyPage.html";
    }

    @RequestMapping(value = "/home/saveUS")
    @ResponseBody
    public void saveUS(Authentication authentication, UserSettingDto dto) {
//        dto.setUser_id(authentication.getName());
//        usservice.saveUS(dto);
    }

    @RequestMapping(value = "/home/getUS")
    @ResponseBody
    public UserSettingDto getUS(Authentication authentication) {
        return new UserSettingDto();
//        return usservice.getUS(authentication.getName());
    }
}
