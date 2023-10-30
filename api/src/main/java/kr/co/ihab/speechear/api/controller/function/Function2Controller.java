package kr.co.ihab.speechear.api.controller.function;

import kr.co.ihab.speechear.api.dto.function.Function2Dto;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class Function2Controller {
//    @Autowired
//    private UserLogComponent userLogComponent;
//
//    @Autowired
//    private UserLogService userLogService;
//
//    @Autowired
//    private AudioInfoService audioInfoService;
//
//    @Autowired
//    private UserService uservice;
//
//    @Autowired
//    private UserActivityService uaservice;

    @RequestMapping(value = "/function/Function2")
    public String home(Authentication authentication, Model model)
    {
//        UserLogDto dto = new UserLogDto(
//                                    userLogComponent.getAccess_Id(),
//                                    userLogComponent.getAccess_ip(),
//                                    userLogComponent.getAccess_Time(),
//                                    userLogComponent.getAccess_role(),
//                                    userLogComponent.getAccess_URI());
//        userLogService.insertUserLog(dto);
//        List<String> memberInfo = new ArrayList<String>();
//        memberInfo.add(uservice.getMemberInfo(authentication.getName()).getName());
//        memberInfo.add(uservice.getMemberInfo(authentication.getName()).getCellphone());
//        model.addAttribute("member", memberInfo);
        
        return "function/Function2.html";
    }

    @PostMapping(value = "/function/Function2/getAudioInfo")
    @ResponseBody
    public List<Function2Dto> getAudioInfo(Function2Dto dto)
    {
        return new ArrayList<>();
//        return audioInfoService.getAudioInfo(dto);
    }

    @PostMapping(value = "/function/Function2/UserActivity")
    @ResponseBody
    public void UserActivity(@RequestBody String activity_time)
    {
//        UserActivityDto dto = new UserActivityDto();
//        dto.setUser_id(userLogComponent.getAccess_Id());
//        dto.setActivity("Function2");
//        dto.setActivity_time(Double.parseDouble(activity_time));
//        uaservice.insertUserActivity(dto);
    }
}
