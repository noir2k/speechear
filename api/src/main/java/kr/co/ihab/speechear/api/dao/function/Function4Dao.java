package kr.co.ihab.speechear.api.dao.function;

import kr.co.ihab.speechear.api.dto.function.Function4Dto;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Function4Dao {
    public List<Function4Dto> getFirstInfo(Function4Dto dto);
    public List<Function4Dto> getAudioInfo(String index);
}
