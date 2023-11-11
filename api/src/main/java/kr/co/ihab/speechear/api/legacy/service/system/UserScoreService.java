package kr.co.ihab.speechear.api.legacy.service.system;

import kr.co.ihab.speechear.api.legacy.dto.system.UserScoreDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

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
