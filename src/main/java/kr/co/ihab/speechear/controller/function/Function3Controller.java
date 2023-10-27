package kr.co.ihab.speechear.controller.function;

import java.util.ArrayList;
import java.util.List;

import kr.co.ihab.speechear.service.AudioInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.ihab.speechear.component.UserLogComponent;
import kr.co.ihab.speechear.dto.function.Function3Dto;
import kr.co.ihab.speechear.dto.system.UserActivityDto;
import kr.co.ihab.speechear.dto.system.UserLogDto;
import kr.co.ihab.speechear.service.security.UserService;
import kr.co.ihab.speechear.service.system.UserActivityService;
import kr.co.ihab.speechear.service.system.UserLogService;

@Controller
public class Function3Controller {
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
    
    @RequestMapping(value = "/function/Function3")
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
        
        return "function/Function3.html";
    }

    @PostMapping(value = "/function/Function3/getAudioInfo")
    @ResponseBody
    public List<Function3Dto> getAudioInfo(Function3Dto dto)
    {
        return new ArrayList<>();
//        return audioInfoService.getAudioInfo(dto);
    }

    @PostMapping(value = "/function/Function3/UserActivity")
    @ResponseBody
    public void UserActivity(@RequestBody String activity_time)
    {
//        UserActivityDto dto = new UserActivityDto();
//        dto.setUser_id(userLogComponent.getAccess_Id());
//        dto.setActivity("Function3");
//        dto.setActivity_time(Double.parseDouble(activity_time));
//        uaservice.insertUserActivity(dto);
    }
}
