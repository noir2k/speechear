package kr.co.ihab.speechear.controller.system;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.ihab.speechear.dto.system.UserLogDto;
import kr.co.ihab.speechear.service.security.UserService;
import kr.co.ihab.speechear.service.system.UserLogService;

@Controller
public class UserLogController {
//    @Autowired
//    private UserLogService service;
//
//    @Autowired
//    private UserService uservice;

    @GetMapping(value = "/system/UserLog")
    public String home(Authentication authentication, Model model) {
//        List<String> memberInfo = new ArrayList<String>();
//        memberInfo.add(uservice.getMemberInfo(authentication.getName()).getName());
//        memberInfo.add(uservice.getMemberInfo(authentication.getName()).getCellphone());
//
//        model.addAttribute("member", memberInfo);
//        model.addAttribute("userList", service.getUserList());
        return "system/UserLog.html";
    }

    @PostMapping(value = "/system/getUserLog")
    @ResponseBody
    public List<UserLogDto> getUserLog(UserLogDto dto) {
        return new ArrayList<>();
//        return service.getUserLog(dto);
    }
}
