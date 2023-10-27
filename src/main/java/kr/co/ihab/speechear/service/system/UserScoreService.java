package kr.co.ihab.speechear.service.system;

import java.util.ArrayList;
import java.util.List;

import kr.co.ihab.speechear.dao.system.UserScoreDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.ihab.speechear.dto.system.UserScoreDto;

@Service
@Transactional
public class UserScoreService {
//    @Autowired
//    private UserScoreDao dao;

    public List<String> getAssignedUser(String manager_id) {
        return new ArrayList<>();
//        return dao.getAssignedUser(manager_id);
    }

    public List<UserScoreDto> getScore(UserScoreDto dto) {
        return new ArrayList<>();
//        return dao.getScore(dto);
    }
}
