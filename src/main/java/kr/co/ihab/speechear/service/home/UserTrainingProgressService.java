package kr.co.ihab.speechear.service.home;

import java.util.List;

import kr.co.ihab.speechear.dao.home.UserSettingDao;
import kr.co.ihab.speechear.dao.home.UserTrainingProgressDao;
import kr.co.ihab.speechear.dao.home.UserTrainingScoreDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.ihab.speechear.dto.home.UserTrainingProgressDto;

@Service
@Transactional
public class UserTrainingProgressService {
//    @Autowired
//    private UserTrainingProgressDao dao;
//
//    @Autowired
//    private UserTrainingScoreDao dao2;
//
//    @Autowired
//    private UserSettingDao dao3;

    public void checkNewMember(UserTrainingProgressDto dto) {
//        if(dao.getUTP(dto).size() == 0) {
//            List<UserTrainingProgressDto> dtol = dao.getUTC();
//            for (UserTrainingProgressDto ulpdto : dtol) {
//                ulpdto.setUser_id(dto.getUser_id());
//            }
//            dao.setUTP(dtol);
//            //UserTrainingScoreDao로 전송
//            dao2.setUTS(dtol);
//            //
//            dao3.setUS(dto.getUser_id());
//        }
    }

    public List<UserTrainingProgressDto> getUTP(UserTrainingProgressDto dto) {
        return null;
//        return dao.getUTP(dto);
    }

    public void saveUTP(UserTrainingProgressDto dto) {
//        dao.saveUTP(dto);
    }
}
