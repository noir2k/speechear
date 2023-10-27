package kr.co.ihab.speechear.dao.home;

import java.util.List;

import org.springframework.stereotype.Repository;

import kr.co.ihab.speechear.dto.home.UserTrainingProgressDto;

@Repository
public interface UserTrainingProgressDao {
    public List<UserTrainingProgressDto> getUTC();
    public void setUTP(List<UserTrainingProgressDto> dto);

    public List<UserTrainingProgressDto> getUTP(UserTrainingProgressDto dto);
    public void saveUTP(UserTrainingProgressDto dto);
}
