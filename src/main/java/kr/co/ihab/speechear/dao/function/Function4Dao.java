package kr.co.ihab.speechear.dao.function;

import java.util.List;

import org.springframework.stereotype.Repository;

import kr.co.ihab.speechear.dto.function.Function4Dto;

@Repository
public interface Function4Dao {
    public List<Function4Dto> getFirstInfo(Function4Dto dto);
    public List<Function4Dto> getAudioInfo(String index);
}
