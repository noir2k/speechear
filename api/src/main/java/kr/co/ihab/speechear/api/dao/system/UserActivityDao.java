package kr.co.ihab.speechear.api.dao.system;

import kr.co.ihab.speechear.api.dto.system.UserActivityDto;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserActivityDao {
    public void insertUserActivity(UserActivityDto dto);
    public List<String> getAssignedUser(String manager_id);
    public List<UserActivityDto> getUserActivity(UserActivityDto dto);
}
