package kr.co.ihab.speechear.api.dao.system;

import kr.co.ihab.speechear.api.dto.system.UserScoreDto;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserScoreDao {
    public List<String> getAssignedUser(String manager_id);
    public List<UserScoreDto> getScore(UserScoreDto dto);
}