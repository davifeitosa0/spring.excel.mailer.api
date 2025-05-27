package com.excel.mailer.api.model;

import lombok.Data;

@Data
public class Mail {

    private String to;
    private String subject;
    private String body;
}
