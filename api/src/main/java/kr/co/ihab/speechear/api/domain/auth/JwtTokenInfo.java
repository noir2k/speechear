package kr.co.ihab.speechear.api.domain.auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class JwtTokenInfo {
    private String grantType;
    private String accessToken;
    private String refreshToken;
}
