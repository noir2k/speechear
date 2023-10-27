package kr.co.ihab.speechear.controller.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;

import kr.co.ihab.speechear.dto.home.UserTrainingScoreDto;
import kr.co.ihab.speechear.service.home.UserTrainingScoreService;

@Controller
public class UserTrainingScoreController {
//    @Autowired
//    private UserTrainingScoreService utsservice;
    
    @RequestMapping(value = "/home/saveUTS")
    @ResponseBody
    public void saveUTS(Authentication authentication,@RequestBody String uts) {
//        String info[] = uts.split("-");
//
//        UserTrainingScoreDto dto = new UserTrainingScoreDto();
//        dto.setUser_id(authentication.getName());
//        dto.setTraining_id(info[0]);
//        dto.setTraining_category(info[1]);
//        dto.setTraining_chapter(Integer.parseInt(info[2])+1);
//        dto.setUser_score(Integer.parseInt(info[3]));
//
//        utsservice.saveUTS(dto);
    }
}
