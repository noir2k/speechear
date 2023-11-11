package kr.co.ihab.speechear.api.legacy.dao.system;

import kr.co.ihab.speechear.api.legacy.dto.system.UserLogDto;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserLogDao {
    public void insertUserLog(UserLogDto dto);
    public List<String> getUserList();
    public List<UserLogDto> getUserLog(UserLogDto dto);
}
