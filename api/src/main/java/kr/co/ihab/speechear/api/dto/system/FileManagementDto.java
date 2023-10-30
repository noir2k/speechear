package kr.co.ihab.speechear.api.dto.system;

import lombok.Data;

@Data
public class FileManagementDto {
    private String name;
    private String extension;
    private String file_path;
    private String date_created;
    private String date_modified;
    private String type;
}
