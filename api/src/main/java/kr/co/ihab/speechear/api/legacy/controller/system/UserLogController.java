package kr.co.ihab.speechear.api.legacy.controller.system;

import kr.co.ihab.speechear.api.legacy.dto.system.UserLogDto;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

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
