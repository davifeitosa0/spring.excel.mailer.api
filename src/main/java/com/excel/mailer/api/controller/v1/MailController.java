package com.excel.mailer.api.controller.v1;

import com.excel.mailer.api.dto.request.MailRequestDto;
import com.excel.mailer.api.mapper.MailMapper;
import com.excel.mailer.api.service.MailService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(MailController.PATH)
@RequiredArgsConstructor
public class MailController {

    protected static final String PATH = "/v1/mail";
    private final MailService mailService;
    private final MailMapper mailMapper;

    @PostMapping
    public ResponseEntity<Void> sendMail(@RequestBody @Valid MailRequestDto mailRequestDto) {
        mailService.sendMail(mailMapper.toDomain(mailRequestDto));
        return ResponseEntity.status(202).build();
    }

}

