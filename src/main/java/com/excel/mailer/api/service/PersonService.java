package com.excel.mailer.api.service;

import com.excel.mailer.api.model.Person;
import java.util.List;
import org.springframework.web.multipart.MultipartFile;

public interface PersonService {

    List<Person> saveFromFile(MultipartFile file);
}
