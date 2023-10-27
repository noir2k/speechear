package kr.co.ihab.speechear.dao.system;

import java.util.List;

import org.springframework.stereotype.Repository;

import kr.co.ihab.speechear.dto.system.FileManagementDto;

@Repository
public interface FileManagementDao {
    public List<FileManagementDto> getFileInfo(FileManagementDto dto);
}
