package kr.co.ihab.speechear.api.domain.user;

import kr.co.ihab.speechear.api.domain.RequestMappings;
import kr.co.ihab.speechear.api.domain.auth.UserInfoDetail;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    @GetMapping(value = RequestMappings.USER_INFO)
    public ResponseEntity<UserInfoResultDTO> userInfo(@AuthenticationPrincipal UserInfoDetail userInfoDetail) {
        return new ResponseEntity<>(userService.getUserInfo(userInfoDetail), HttpStatus.OK);
    }

    @PostMapping(value = RequestMappings.USER_UPDATE_INFO)
    public ResponseEntity<Boolean> userUpdateInfo(
            @AuthenticationPrincipal UserInfoDetail userInfoDetail,
            @RequestBody UserInfoUpdateRequestDTO dto
    ) {
        return new ResponseEntity<>(userService.updateUserInfo(userInfoDetail, dto), HttpStatus.OK);
    }

    @PostMapping(value = RequestMappings.USER_UPDATE_PASSWORD)
    public ResponseEntity<Boolean> userUpdatePassword(
            @AuthenticationPrincipal UserInfoDetail userInfoDetail,
            @RequestBody UserPassUpdateRequestDTO dto
    ) {
        return new ResponseEntity<>(userService.updateUserPassword(userInfoDetail, dto), HttpStatus.OK);
    }
}
