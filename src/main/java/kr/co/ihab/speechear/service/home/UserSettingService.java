package kr.co.ihab.speechear.service.home;

import kr.co.ihab.speechear.dao.home.UserSettingDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.ihab.speechear.dto.home.UserSettingDto;

@Service
@Transactional
public class UserSettingService {
//    @Autowired
//    private UserSettingDao dao;

    public UserSettingDto getUS(String user_id) {
        return new UserSettingDto();
//        return dao.getUS(user_id);
    }

    public void saveUS(UserSettingDto dto) {
//        dao.saveUS(dto);
    }
}
