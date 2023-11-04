package kr.co.ihab.speechear.api.component.exception;

import kr.co.ihab.speechear.api.interfaces.ErrorCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class RestApiException extends RuntimeException {
    private final ErrorCode errorCode;
}
