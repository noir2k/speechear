package kr.co.ihab.speechear.dto.system;

import lombok.Data;

@Data
public class UserActivityDto {
    private String manager_id;
    private String user_id;
    private String activity;
    private double activity_time;
    private String activity_date;
}
