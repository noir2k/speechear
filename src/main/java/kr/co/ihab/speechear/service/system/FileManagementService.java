package kr.co.ihab.speechear.service.system;

import jakarta.transaction.Transactional;
import kr.co.ihab.speechear.dao.system.FileManagementDao;
import kr.co.ihab.speechear.dto.system.FileManagementDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class FileManagementService {
//    @Autowired
//    private FileManagementDao dao;

    public List<FileManagementDto> getFileInfo(FileManagementDto dto) {
        return new ArrayList<>();
//        return dao.getFileInfo(dto);
    }
}
