package kr.co.ihab.speechear.api.dto.home;

import lombok.Data;

@Data
public class UserSettingDto {
    private String user_id;
    private String noise_type;
    private String play_speed;
}
