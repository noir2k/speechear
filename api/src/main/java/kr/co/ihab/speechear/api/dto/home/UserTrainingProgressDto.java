package kr.co.ihab.speechear.api.dto.home;

import lombok.Data;

@Data
public class UserTrainingProgressDto {
    private String user_id;
    private String training_id;
    private String training_category;
    private int training_chapter;
    private int chapter_length;
    private int user_act;
}
