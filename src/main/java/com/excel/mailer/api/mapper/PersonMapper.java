package com.excel.mailer.api.mapper;

import com.excel.mailer.api.dto.PersonDto;
import com.excel.mailer.api.dto.response.PersonResponseDto;
import com.excel.mailer.api.entity.PersonEntity;
import com.excel.mailer.api.model.Person;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PersonMapper {

    List<Person> toDomain(List<PersonDto> personsDto);

    Person toDomain(PersonDto personDto);

    Person toDomain(PersonEntity personEntity);

    List<Person> entityToDomain(List<PersonEntity> personEntity);

    PersonEntity toEntity(Person person);

    List<PersonEntity> toEntity(List<Person> person);

    PersonResponseDto toResponseDto(Person person);

    List<PersonResponseDto> toResponseDto(List<Person> persons);
}
