package kr.co.ihab.speechear.dao.system;

import java.util.List;

import org.springframework.stereotype.Repository;

import kr.co.ihab.speechear.dto.system.UserActivityDto;

@Repository
public interface UserActivityDao {
    public void insertUserActivity(UserActivityDto dto);
    public List<String> getAssignedUser(String manager_id);
    public List<UserActivityDto> getUserActivity(UserActivityDto dto);
}
