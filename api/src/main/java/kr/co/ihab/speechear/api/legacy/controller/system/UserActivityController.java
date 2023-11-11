package kr.co.ihab.speechear.api.legacy.controller.system;

import kr.co.ihab.speechear.api.legacy.dto.system.UserActivityDto;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserActivityController {    
//    @Autowired
//    private UserActivityService uaservice;
//
//    @Autowired
//    private UserService uservice;
    
    @GetMapping(value = "/system/UserActivity")
    public String home(Authentication authentication, Model model) {
//        List<String> memberInfo = new ArrayList<String>();
//        memberInfo.add(uservice.getMemberInfo(authentication.getName()).getName());
//        memberInfo.add(uservice.getMemberInfo(authentication.getName()).getCellphone());
//
//        model.addAttribute("member", memberInfo);
//        model.addAttribute("assignedUser", uaservice.getAssignedUser(authentication.getName()));

        return "system/UserActivity.html";
    }

    @PostMapping(value = "/system/getUserActivity")
    @ResponseBody
    public List<UserActivityDto> getUserActivity(Authentication authentication,UserActivityDto dto) {
        return new ArrayList<>();
//        dto.setManager_id(authentication.getName());
//        return uaservice.getUserActivity(dto);
    }
}
