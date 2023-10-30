package kr.co.ihab.speechear.api.service.home;

import kr.co.ihab.speechear.api.dto.home.UserSettingDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
