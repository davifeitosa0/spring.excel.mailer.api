package com.excel.mailer.api.adapter;

import com.excel.mailer.api.dto.PersonDto;
import com.excel.mailer.api.mapper.PersonMapper;
import com.excel.mailer.api.model.Person;
import com.excel.mailer.api.provider.XlsxProvider;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;


@Component
@Slf4j
@RequiredArgsConstructor
public class XlsxAdapter implements XlsxProvider {

    private final PersonMapper personMapper;
    private final DataFormatter formatter = new DataFormatter();

    public List<Person> readPersonsXlsx(MultipartFile file) {
        List<PersonDto> persons = new ArrayList<>();
        try (var inputStream = file.getInputStream(); Workbook workbook = new XSSFWorkbook(
              inputStream)) {
            Sheet sheet = workbook.getSheetAt(0);
            log.info("Reading XLSX file: {}", file.getOriginalFilename());
            for (Row row : sheet) {
                persons.add(mapRowToPerson(row));
            }
        } catch (Exception e) {
            log.error("Error reading XLSX file", e);
            throw new IllegalArgumentException("Error exporting file ", e);
        }
        return personMapper.toDomain(persons);
    }

    private PersonDto mapRowToPerson(Row row) {
        PersonDto person = new PersonDto();
        for (Cell cell : row) {
            mapCellToPerson(cell, person);
        }
        return person;
    }

    private void mapCellToPerson(Cell cell, PersonDto person) {
        if (cell == null) {
            return;
        }
        switch (cell.getColumnIndex()) {
            case 0 -> person.setName(formatter.formatCellValue(cell));
            case 1 -> person.setEmail(formatter.formatCellValue(cell));
            default -> log.warn("Unexpected column index: {}", cell.getColumnIndex());
        }
    }
}
