package com.excel.mailer.api.adapter;

import com.excel.mailer.api.mapper.PersonMapper;
import com.excel.mailer.api.model.Person;
import com.excel.mailer.api.persistence.PersonPersistence;
import com.excel.mailer.api.repository.PersonRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PersonAdapter implements PersonPersistence {

    private final PersonRepository personRepository;
    private final PersonMapper personMapper;

    @Override
    public List<Person> saveAll(List<Person> person) {
        return personMapper.entityToDomain(personRepository.saveAll(personMapper.toEntity(person)));
    }
}
