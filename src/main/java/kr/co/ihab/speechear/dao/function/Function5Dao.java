package kr.co.ihab.speechear.dao.function;

import java.util.List;

import kr.co.ihab.speechear.dto.function.Function5Dto;
import org.springframework.stereotype.Repository;

@Repository
public interface Function5Dao {
    public Function5Dto loadFile(Function5Dto dto);
    public List<String> getAudioList(Function5Dto dto);
}
