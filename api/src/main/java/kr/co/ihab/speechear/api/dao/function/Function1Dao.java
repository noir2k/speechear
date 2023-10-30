package kr.co.ihab.speechear.api.dao.function;

import kr.co.ihab.speechear.api.dto.function.Function1Dto;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Function1Dao {
    public List<Function1Dto> getAudioInfo(Function1Dto dto);
}