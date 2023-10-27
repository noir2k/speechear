package kr.co.ihab.speechear.service.system;

import java.util.ArrayList;
import java.util.List;

import kr.co.ihab.speechear.dao.system.UserLogDao;
import kr.co.ihab.speechear.dto.system.UserLogDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
