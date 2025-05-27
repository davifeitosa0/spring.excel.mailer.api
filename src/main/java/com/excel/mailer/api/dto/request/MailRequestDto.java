package com.excel.mailer.api.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class MailRequestDto {

    @NotBlank
    private String to;
    @NotBlank
    private String subject;
    @NotBlank
    private String body;
}
