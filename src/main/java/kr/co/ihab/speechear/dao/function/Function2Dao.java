package kr.co.ihab.speechear.dao.function;

import java.util.List;

import kr.co.ihab.speechear.dto.function.Function2Dto;
import org.springframework.stereotype.Repository;

@Repository
public interface Function2Dao {
    public List<Function2Dto> getAudioInfo(Function2Dto dto);
}
