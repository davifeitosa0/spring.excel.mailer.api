package com.excel.mailer.api.controller.handler;

import com.excel.mailer.api.exception.MailBadGateway;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
@NoArgsConstructor
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(value = HttpStatus.BAD_GATEWAY)
    @ExceptionHandler(MailBadGateway.class)
    public ErrorResponse handleException(Exception ex) {
        logMessage(ex.getMessage());
        return new ErrorResponse(
              "Error processing the request: failure in communication with the email service.",
              HttpStatus.BAD_GATEWAY);
    }


    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(IllegalArgumentException.class)
    public ErrorResponse handleIllegalArgumentException(IllegalArgumentException ex) {
        logMessage(ex.getMessage());
        return new ErrorResponse("Error processing the request", HttpStatus.BAD_REQUEST);
    }

    private static void logMessage(String ex) {
        log.error("Error message: {}", ex);
    }

}
