package kr.co.ihab.speechear.api.component.exception;

import kr.co.ihab.speechear.api.interfaces.ErrorCode;
import lombok.*;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.ArrayList;
import java.util.List;

@Builder
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class RestApiErrorResponse {

    private String code;
    private String message;
    private List<FieldError> errors;

    private RestApiErrorResponse(ErrorCode code, List<FieldError> fieldErrors) {
        this.code = code.getCode();
        this.message = code.getMessage();
        this.errors = fieldErrors;
    }

    private RestApiErrorResponse(ErrorCode code) {
        this.code = code.getCode();
        this.message = code.getMessage();
        this.errors = new ArrayList<>();
    }

    public static RestApiErrorResponse of(final ErrorCode code, final BindingResult bindingResult) {
        return new RestApiErrorResponse(code, bindingResult.getFieldErrors());
    }

    public static RestApiErrorResponse of(final ErrorCode code) {
        return new RestApiErrorResponse(code);
    }
}
