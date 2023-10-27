package kr.co.ihab.speechear.dao.home;

import java.util.List;

import org.springframework.stereotype.Repository;

import kr.co.ihab.speechear.dto.home.UserTrainingProgressDto;
import kr.co.ihab.speechear.dto.home.UserTrainingScoreDto;

@Repository
public interface UserTrainingScoreDao {
    //UserTrainingProgressService에서 불림
    public void setUTS(List<UserTrainingProgressDto> dto);

    public void saveUTS(UserTrainingScoreDto dto);
}
