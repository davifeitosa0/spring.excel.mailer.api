package com.excel.mailer.api.service.impl;

import com.excel.mailer.api.model.Mail;
import com.excel.mailer.api.provider.MailProvider;
import com.excel.mailer.api.service.MailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class MailServiceImpl implements MailService {

    private final MailProvider mailProvider;

    @Override
    public void sendMail(Mail mail) {
        mailProvider.sendMail(mail);
    }
}
