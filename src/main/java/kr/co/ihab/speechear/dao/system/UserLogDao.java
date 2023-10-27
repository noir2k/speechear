package kr.co.ihab.speechear.dao.system;

import java.util.List;

import org.springframework.stereotype.Repository;

import kr.co.ihab.speechear.dto.system.UserLogDto;

@Repository
public interface UserLogDao {
    public void insertUserLog(UserLogDto dto);
    public List<String> getUserList();
    public List<UserLogDto> getUserLog(UserLogDto dto);
}
