package kr.co.ihab.speechear.api.service.system;

import kr.co.ihab.speechear.api.dto.system.UserLogDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class UserLogService {
//    @Autowired
//    private UserLogDao dao;

    public void insertUserLog(UserLogDto dto) {
//        dao.insertUserLog(dto);
    }

    public List<String> getUserList() {
        return new ArrayList<>();
//        return dao.getUserList();
    }

    public List<UserLogDto> getUserLog(UserLogDto dto) {
        return new ArrayList<>();
//        return dao.getUserLog(dto);
    }
}
