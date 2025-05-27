package com.excel.mailer.api.model;

import java.util.UUID;
import lombok.Data;

@Data
public class Person {

    private UUID id;
    private String name;
    private String email;
    private boolean hasSent;
}
