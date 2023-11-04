package kr.co.ihab.speechear.api.component.handler;

import kr.co.ihab.speechear.api.component.exception.RestApiErrorResponse;
import kr.co.ihab.speechear.api.enums.CommonErrorCode;
import kr.co.ihab.speechear.api.interfaces.ErrorCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(Exception.class)
    protected ResponseEntity<RestApiErrorResponse> handleException(Exception e) {
        log.error(e.getMessage(), e);

        CommonErrorCode errorCode = CommonErrorCode.INTERNAL_SERVER_ERROR;
        RestApiErrorResponse response = RestApiErrorResponse.of(errorCode);

        return new ResponseEntity<>(response, errorCode.getHttpStatus());
    }

    @ExceptionHandler(RuntimeException.class)
    protected ResponseEntity<RestApiErrorResponse> handleRuntimeException(RuntimeException e) {
        log.error(e.getMessage(), e);

        RestApiErrorResponse response =
                RestApiErrorResponse.builder()
                        .message(e.getMessage())
                        .code(e.getClass().getSimpleName())
                        .build();

        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private ResponseEntity<Object> handleExceptionInternal(
            Exception e, ErrorCode errorCode, WebRequest request) {
        log.error(e.getMessage(), e);
        return handleExceptionInternal(e, errorCode, errorCode.getHttpStatus(), request);
    }

    private ResponseEntity<Object> handleExceptionInternal(
            Exception e, ErrorCode errorCode, HttpStatus status, WebRequest request) {
        return super.handleExceptionInternal(
                e, RestApiErrorResponse.of(errorCode), HttpHeaders.EMPTY, status, request);
    }
}
