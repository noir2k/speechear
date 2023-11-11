package kr.co.ihab.speechear.api.legacy.dao.home;

import kr.co.ihab.speechear.api.legacy.dto.home.UserTrainingProgressDto;
import kr.co.ihab.speechear.api.legacy.dto.home.UserTrainingScoreDto;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserTrainingScoreDao {
    //UserTrainingProgressService에서 불림
    public void setUTS(List<UserTrainingProgressDto> dto);

    public void saveUTS(UserTrainingScoreDto dto);
}
