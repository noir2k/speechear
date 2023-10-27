package kr.co.ihab.speechear.dao.function;

import java.util.List;

import kr.co.ihab.speechear.dto.function.Function3Dto;
import org.springframework.stereotype.Repository;

@Repository
public interface Function3Dao {
    public List<Function3Dto> getAudioInfo(Function3Dto dto);
}
