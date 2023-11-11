package kr.co.ihab.speechear.api.legacy.service.system;

import kr.co.ihab.speechear.api.legacy.dto.system.UserActivityDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class UserActivityService {
//    @Autowired
//    private UserActivityDao dao;

    public void insertUserActivity(UserActivityDto dto) {
//        dao.insertUserActivity(dto);
    }

    public List<String> getAssignedUser(String manager_id) {
        return new ArrayList<>();
//        return dao.getAssignedUser(manager_id);
    }

    public List<UserActivityDto> getUserActivity(UserActivityDto dto) {
        return new ArrayList<>();
//        return dao.getUserActivity(dto);
    }
}
