package umc.easyexcel.apiPayload.exception;

import lombok.*;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    VALUE_NOT_IN_OPTION(HttpStatus.BAD_REQUEST, "선택지에 없는 값을 사용했습니다.", "선택지에 있는 값을 사용해야 합니다.");

    private final HttpStatus httpStatus;
    private final String message;
    private final String solution;
}