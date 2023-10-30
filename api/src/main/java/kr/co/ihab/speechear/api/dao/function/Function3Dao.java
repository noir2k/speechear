package kr.co.ihab.speechear.api.dao.function;

import kr.co.ihab.speechear.api.dto.function.Function3Dto;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Function3Dao {
    public List<Function3Dto> getAudioInfo(Function3Dto dto);
}
