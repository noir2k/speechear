package kr.co.ihab.speechear.api.domain.user;

import lombok.Data;

@Data
public class UserDTO {
    private String id;
    private String name;
    private String email;
    private String cellPhone;
}
