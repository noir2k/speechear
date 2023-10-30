package kr.co.ihab.speechear.api.dao.function;

import kr.co.ihab.speechear.api.dto.function.Function2Dto;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Function2Dao {
    public List<Function2Dto> getAudioInfo(Function2Dto dto);
}
