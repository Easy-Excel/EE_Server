package umc.easyexcel.apiPayload.exception;

import lombok.*;

@Getter
public class EasyExcelException extends RuntimeException {
    private int status;
    private String message;
    private String solution;

    public EasyExcelException(ErrorCode errorCode) {
        this.message = errorCode.getMessage();
        this.status = errorCode.getHttpStatus().value();
        this.solution = errorCode.getSolution();
    }

    public EasyExcelException(ErrorCode errorCode, String message) {
        this.message = message;
        this.status = errorCode.getHttpStatus().value();
        this.solution = errorCode.getSolution();
    }

    public EasyExcelException(ErrorCode errorCode, String message, String solution) {
        this.message = message;
        this.status = errorCode.getHttpStatus().value();
        this.solution = solution;
    }
}
