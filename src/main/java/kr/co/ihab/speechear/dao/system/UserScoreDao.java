package kr.co.ihab.speechear.dao.system;

import java.util.List;

import org.springframework.stereotype.Repository;

import kr.co.ihab.speechear.dto.system.UserScoreDto;

@Repository
public interface UserScoreDao {
    public List<String> getAssignedUser(String manager_id);
    public List<UserScoreDto> getScore(UserScoreDto dto);
}