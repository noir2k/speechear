package kr.co.ihab.speechear.api.legacy.controller.system;

import kr.co.ihab.speechear.api.legacy.dto.system.UserScoreDto;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserScoreController {
//    @Autowired
//    private UserService uservice;
//
//    @Autowired
//    private UserScoreService usservice;

    @GetMapping(value = "/system/UserScore")
    public String home(Authentication authentication, Model model) {
//        List<String> memberInfo = new ArrayList<String>();
//        memberInfo.add(uservice.getMemberInfo(authentication.getName()).getName());
//        memberInfo.add(uservice.getMemberInfo(authentication.getName()).getCellphone());
//
//        model.addAttribute("member", memberInfo);
//        model.addAttribute("assignedUser",usservice.getAssignedUser(authentication.getName()));

        return "system/UserScore.html";
    }

    //사용자 점수 조회 : 매니저만 사용 가능
    @RequestMapping(value = "/system/getScore")
    @ResponseBody
    public List<UserScoreDto> getScore(Authentication authentication,UserScoreDto dto) {
        return new ArrayList<>();
//        dto.setManager_id(authentication.getName());
//        return usservice.getScore(dto);
    }
}
