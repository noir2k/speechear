package kr.co.ihab.speechear.api.dao.function;

import kr.co.ihab.speechear.api.dto.function.Function5Dto;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Function5Dao {
    public Function5Dto loadFile(Function5Dto dto);
    public List<String> getAudioList(Function5Dto dto);
}
