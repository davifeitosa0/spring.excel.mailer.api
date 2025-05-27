package com.excel.mailer.api.controller.handler;

import java.time.LocalDateTime;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class ErrorResponse {

    private LocalDateTime timestamp;
    private String details;
    private HttpStatus exceptionCode;

    public ErrorResponse(String errorMessage, HttpStatus exceptionCode) {
        this.timestamp = LocalDateTime.now();
        this.exceptionCode = exceptionCode;
        this.details = errorMessage;
    }
}
