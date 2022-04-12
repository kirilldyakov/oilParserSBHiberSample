package com.example.oil.service;

import com.example.oil.model.ColumnType;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Service
public class ExcelService {
    String DEFAULT_FILENAME = "Задание.xlsx";

    @Autowired
    StorageService storageService;

    public void start(@Nullable String filename) {
        try {
            Sheet sheet = openXlsFile(filename);

            HashMap<Integer, HashMap<Integer, String>> header = new HashMap<>();
            for (int r = 0; r < sheet.getLastRowNum(); r++) {
                HashMap<Integer, String> permanentColumns = new HashMap<>();
                for (int c = 0; c < sheet.getRow(r).getLastCellNum() - 1; c++) {
                    if (r < 3) {
                        readHeader(sheet, header, r, c);
                    } else {
                        if (c < 2) {
                            readPermanentColumns(sheet, permanentColumns, r, c);
                        } else {
                            saveData(sheet, header, permanentColumns, r, c);
                        }
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Sheet openXlsFile(String filename) throws IOException {
        FileInputStream file = new FileInputStream(filename != null ? filename : DEFAULT_FILENAME);
        Workbook workbook = new XSSFWorkbook(file);

        return workbook.getSheetAt(0);
    }

    private void saveData(Sheet sheet, HashMap<Integer, HashMap<Integer, String>> header,HashMap<Integer, String> permanent, int r, int c) {
        HashMap<String, String> map = new HashMap<>();
        //map.put("date", DateUtils.getRandomDate());

        map.put("ext_id", permanent.get(0));
        map.put("company", permanent.get(1));

        int i=0;
        for(Map.Entry<Integer, String> entry: header.get(c).entrySet()){
            map.put(Objects.requireNonNull(ColumnType.get(i++)).name, entry.getValue());
        }

        map.put("value", readValue(sheet, r, c));
        System.out.println(map);

        storageService.save(map);
    }

    private void readPermanentColumns(Sheet sheet, HashMap<Integer, String> permanent, int row, int col) {
        String val = readValue(sheet, row, col);
        permanent.put(col, val);
    }


    private void readHeader(Sheet sheet, HashMap<Integer, HashMap<Integer, String>> header, int row, int col) {
        int offset = 0;
        String val = sheet.getRow(row).getCell(col - offset).getStringCellValue();
        while (offset <= col && val.isEmpty()) {
            val = sheet.getRow(row).getCell(col - offset).getStringCellValue();
            offset++;
        }
        if (!val.isEmpty()) {
            HashMap<Integer, String> column = header.containsKey(col) ? header.get(col) : new HashMap<>();
            column.put(row, val);
            header.put(col, column);
        }
    }

    private String readValue(Sheet sheet, int row, int col) {
        Cell cell = sheet.getRow(row).getCell(col);
        return switch (cell.getCellType()) {
            case STRING -> cell.getStringCellValue();
            case NUMERIC -> String.valueOf(Math.round(cell.getNumericCellValue()));
            case BOOLEAN -> String.valueOf(cell.getBooleanCellValue());
            default -> null;
        };
    }

}
