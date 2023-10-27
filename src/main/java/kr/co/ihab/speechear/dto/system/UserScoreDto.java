package kr.co.ihab.speechear.dto.system;

import lombok.Data;

@Data
public class UserScoreDto {
    private String manager_id;
    private String user_id;
    private String training_id;
    private String training_category;
    private int training_chapter;
    private int chapter_length;
    private int user_score;

    private String training_name;
    private String category_name;
    private int act_percent;
}
