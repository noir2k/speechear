package kr.co.ihab.speechear.api.legacy.dao.home;

import kr.co.ihab.speechear.api.legacy.dto.home.UserTrainingProgressDto;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserTrainingProgressDao {
    public List<UserTrainingProgressDto> getUTC();
    public void setUTP(List<UserTrainingProgressDto> dto);

    public List<UserTrainingProgressDto> getUTP(UserTrainingProgressDto dto);
    public void saveUTP(UserTrainingProgressDto dto);
}
