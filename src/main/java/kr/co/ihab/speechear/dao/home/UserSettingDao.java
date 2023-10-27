package kr.co.ihab.speechear.dao.home;

import org.springframework.stereotype.Repository;

import kr.co.ihab.speechear.dto.home.UserSettingDto;

@Repository
public interface UserSettingDao {
    void setUS(String user_id);
    UserSettingDto getUS(String user_id);
    void saveUS(UserSettingDto dto);
}
