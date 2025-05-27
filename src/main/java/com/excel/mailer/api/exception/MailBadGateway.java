package com.excel.mailer.api.exception;

public class MailBadGateway extends RuntimeException {

    public MailBadGateway(String message) {
        super(message);
    }
}
