package kr.co.ihab.speechear.service.system;

import java.util.ArrayList;
import java.util.List;

import kr.co.ihab.speechear.dao.system.UserActivityDao;
import kr.co.ihab.speechear.dto.system.UserActivityDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
