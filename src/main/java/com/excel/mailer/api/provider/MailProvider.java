package com.excel.mailer.api.provider;

import com.excel.mailer.api.model.Mail;

public interface MailProvider {

    void sendMail(Mail mail);
}
