package com.excel.mailer.api.service;

import com.excel.mailer.api.model.Mail;

public interface MailService {

    void sendMail(Mail mail);
}
