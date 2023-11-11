package kr.co.ihab.speechear.api.domain.user;

import lombok.Data;

@Data
public class UserPassUpdateRequestDTO {
    private String originPassword;
    private String newPassword;
}
