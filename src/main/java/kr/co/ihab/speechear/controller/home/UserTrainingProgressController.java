package kr.co.ihab.speechear.controller.home;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.ihab.speechear.dto.home.UserTrainingProgressDto;
import kr.co.ihab.speechear.service.home.UserTrainingProgressService;

@Controller
public class UserTrainingProgressController {
//    @Autowired
//    private UserTrainingProgressService utpservice;

    @RequestMapping(value = "/home/checkNewMember")
    @ResponseBody
    public void checkNewMember(Authentication authentication) {
//        UserTrainingProgressDto dto = new UserTrainingProgressDto();
//        dto.setUser_id(authentication.getName());
//        dto.setTraining_id("f1");
//        utpservice.checkNewMember(dto);
    }

    @RequestMapping(value = "/home/getUTP")
    @ResponseBody
    public List<UserTrainingProgressDto> getUTP(Authentication authentication,UserTrainingProgressDto dto) {
        return new ArrayList<>();
//        dto.setUser_id(authentication.getName());
//        return utpservice.getUTP(dto);
    }

    @RequestMapping(value = "/home/saveUTP")
    @ResponseBody
    public void saveUTP(Authentication authentication,@RequestBody String utp) {
//        String info[] = utp.split("-");
//
//        UserTrainingProgressDto dto = new UserTrainingProgressDto();
//        dto.setUser_id(authentication.getName());
//        dto.setTraining_id(info[0]);
//        dto.setTraining_category(info[1]);
//        dto.setTraining_chapter(Integer.parseInt(info[2])+1);
//        dto.setUser_act(Integer.parseInt(info[3])-1);
//
//        utpservice.saveUTP(dto);
    }
}
