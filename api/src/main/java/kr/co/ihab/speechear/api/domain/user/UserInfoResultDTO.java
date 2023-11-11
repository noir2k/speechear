package kr.co.ihab.speechear.api.domain.user;

import lombok.Data;

@Data
public class UserInfoResultDTO {
    private UserDTO user;
    private UserDTO manager;
}
