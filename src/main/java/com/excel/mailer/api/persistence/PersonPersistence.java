package com.excel.mailer.api.persistence;

import com.excel.mailer.api.model.Person;
import java.util.List;

public interface PersonPersistence {

    List<Person> saveAll(List<Person> person);
}

