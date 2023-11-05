package kr.co.ihab.speechear.api.domain.auth;

import jakarta.validation.Valid;
import kr.co.ihab.speechear.api.component.JwtTokenComponent;
import kr.co.ihab.speechear.api.domain.RequestMappings;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class AuthController {
    private final AuthenticationManager authenticationManager;
    private final JwtTokenComponent jwtProvider;
    @PostMapping(value = RequestMappings.SIGNIN)
    public ResponseEntity<?> loginUser(@Valid @RequestBody LoginRequestDTO dto) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        dto.getUsername(),
                        dto.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        JwtTokenInfo jwtInfo = jwtProvider.generateJwtToken(authentication);

        return new ResponseEntity<>(jwtInfo, HttpStatus.OK);
    }

    @PostMapping(value = RequestMappings.SIGNUP)
    public ResponseEntity<?> registerUser(@Valid @RequestBody LoginRequestDTO dto) {
        return new ResponseEntity<>("OK", HttpStatus.OK);
    }
}
