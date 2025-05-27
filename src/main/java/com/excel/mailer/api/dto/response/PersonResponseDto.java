package com.excel.mailer.api.dto.response;

import lombok.Data;

@Data
public class PersonResponseDto {

    private String id;
    private String name;
    private String email;
    private boolean hasSent;
}
