package com.excel.mailer.api.provider;

import com.excel.mailer.api.model.Person;
import java.util.List;
import org.springframework.web.multipart.MultipartFile;

public interface XlsxProvider {

    List<Person> readPersonsXlsx(MultipartFile file);

}
