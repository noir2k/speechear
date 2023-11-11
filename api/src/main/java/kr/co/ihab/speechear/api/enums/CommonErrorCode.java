package kr.co.ihab.speechear.api.enums;

import kr.co.ihab.speechear.api.interfaces.ErrorCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum CommonErrorCode implements ErrorCode {
    INVALID_PARAMETER(HttpStatus.BAD_REQUEST.name(), HttpStatus.BAD_REQUEST, "Invalid parameter included"),
    RESOURCE_NOT_FOUND(HttpStatus.NOT_FOUND.name(), HttpStatus.NOT_FOUND, "Resource not exists"),
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR.name(), HttpStatus.INTERNAL_SERVER_ERROR, "Internal server error"),
    PASSWORD_NOT_MATCHED(HttpStatus.BAD_REQUEST.name(), HttpStatus.BAD_REQUEST, "비밀번호가 일치하지 않습니다."),
    ;

    private final String code;
    private final HttpStatus httpStatus;
    private final String message;
}
