package kr.co.ihab.speechear.dao.function;

import java.util.List;

import kr.co.ihab.speechear.dto.function.Function1Dto;
import org.springframework.stereotype.Repository;

@Repository
public interface Function1Dao {
    public List<Function1Dto> getAudioInfo(Function1Dto dto);
}