package kr.co.ihab.speechear.api.dao.system;

import kr.co.ihab.speechear.api.dto.system.FileManagementDto;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FileManagementDao {
    public List<FileManagementDto> getFileInfo(FileManagementDto dto);
}
