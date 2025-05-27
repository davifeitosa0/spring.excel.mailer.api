package com.excel.mailer.api.controller.v1;

import com.excel.mailer.api.dto.response.PersonResponseDto;
import com.excel.mailer.api.mapper.PersonMapper;
import com.excel.mailer.api.service.PersonService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@RestController
@RequestMapping(PersonController.PATH)
@RequiredArgsConstructor
public class PersonController {

    protected static final String PATH = "/v1/persons";
    private final PersonService personService;
    private final PersonMapper personMapper;

    @PostMapping
    public ResponseEntity<List<PersonResponseDto>> sendMail(
          @RequestParam("file") MultipartFile file) {
        personService.saveFromFile(file);
        return ResponseEntity.ok()
              .body(personMapper.toResponseDto(personService.saveFromFile(file)));
    }
}

