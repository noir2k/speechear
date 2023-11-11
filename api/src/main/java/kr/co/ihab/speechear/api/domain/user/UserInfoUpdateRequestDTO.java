package kr.co.ihab.speechear.api.domain.user;

import lombok.Data;

@Data
public class UserInfoUpdateRequestDTO {
    private String name;
    private String email;
    private String cellPhone;
}
