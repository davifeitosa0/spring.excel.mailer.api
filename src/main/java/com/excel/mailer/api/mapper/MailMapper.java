package com.excel.mailer.api.mapper;

import com.excel.mailer.api.dto.request.MailRequestDto;
import com.excel.mailer.api.model.Mail;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MailMapper {

    Mail toDomain(MailRequestDto mailRequestDto);
}
