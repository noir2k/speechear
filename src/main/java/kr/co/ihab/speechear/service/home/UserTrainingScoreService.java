package kr.co.ihab.speechear.service.home;

import kr.co.ihab.speechear.dao.home.UserTrainingScoreDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.ihab.speechear.dto.home.UserTrainingScoreDto;

@Service
@Transactional
public class UserTrainingScoreService {
//    @Autowired
//    private UserTrainingScoreDao dao;

    public void saveUTS(UserTrainingScoreDto dto) {
//        dao.saveUTS(dto);
    }
}
