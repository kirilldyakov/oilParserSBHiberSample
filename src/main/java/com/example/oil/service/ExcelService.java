package com.example.oil.service;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ExcelService {
    String DEFAULT_FILENAME = "Задание.xlsx";

    public void start(@Nullable String filename) {
        try {
            FileInputStream file = new FileInputStream(filename != null ? filename : DEFAULT_FILENAME);
            Workbook workbook = new XSSFWorkbook(file);

            Sheet sheet = workbook.getSheetAt(0);

            Map<Integer, List<String>> data = new HashMap<>();
            int i = 0;
            for (Row row : sheet) {
                data.put(i, new ArrayList<>());
                for (Cell cell : row) {
                    String value = getStringCellValue(cell);
                    System.out.println(value);
//                    switch (cell.getCellType()) {
//                        case STRING: ... break;
//                        case NUMERIC: ... break;
//                        case BOOLEAN: ... break;
//                        case FORMULA: ... break;
//                        default: data.get(new Integer(i)).add(" ");
//                    }
                }
                i++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("50");
            e.printStackTrace();
        }
    }

    private String getStringCellValue(Cell cell) {
        return cell.getStringCellValue();
    }

}
