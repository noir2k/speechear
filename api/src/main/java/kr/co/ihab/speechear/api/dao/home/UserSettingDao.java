package kr.co.ihab.speechear.api.dao.home;

import kr.co.ihab.speechear.api.dto.home.UserSettingDto;
import org.springframework.stereotype.Repository;

@Repository
public interface UserSettingDao {
    void setUS(String user_id);
    UserSettingDto getUS(String user_id);
    void saveUS(UserSettingDto dto);
}
