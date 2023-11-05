package kr.co.ihab.speechear.api.domain.auth;

import lombok.Data;

@Data
public class JWTResponseDTO {
    private String accToken;
    private String refToken;

    public JWTResponseDTO(String accessToken) {
        this.accToken = accessToken;
    }
}
