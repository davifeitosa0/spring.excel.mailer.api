package com.excel.mailer.api.adapter;

import com.excel.mailer.api.exception.MailBadGateway;
import com.excel.mailer.api.model.Mail;
import com.excel.mailer.api.provider.MailProvider;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class MailAdapter implements MailProvider {

    private final JavaMailSender mailSender;

    @Override
    public void sendMail(Mail mail) {
        try {
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper message = new MimeMessageHelper(mimeMessage, true, "UTF-8");
            message.setTo(mail.getTo());
            message.setSubject(mail.getSubject());
            message.setText(mail.getBody(), true);
            mailSender.send(mimeMessage);
        } catch (MessagingException e) {
            log.error("Error sending email: {}", e.getMessage());
            throw new MailBadGateway("Failed to send email");
        }
    }
}
