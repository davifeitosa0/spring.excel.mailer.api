package com.excel.mailer.api.service.impl;

import com.excel.mailer.api.model.Person;
import com.excel.mailer.api.persistence.PersonPersistence;
import com.excel.mailer.api.provider.XlsxProvider;
import com.excel.mailer.api.service.PersonService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final XlsxProvider xlsxProvider;
    private final PersonPersistence personPersistence;

    @Override
    public List<Person> saveFromFile(MultipartFile file) {
        var persons = xlsxProvider.readPersonsXlsx(file);
        log.info("Saving [{}] persons", persons.size());
        return personPersistence.saveAll(persons);
    }
}
