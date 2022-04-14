package com.example.oil.service;

import com.example.oil.repository.DataRepository;
import com.example.oil.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ReportService {
    @Autowired
    DataRepository dataRepository;

    public void makeReport() {
        List<ReportRow> reportData = computeData();
        printReport(reportData);
    }

    private List<ReportRow> computeData() {
        List<ReportRow> reportData = dataRepository.findAll()
                .stream()
                .filter((p) -> p.getCompany().getName().equals("company1"))
                .filter((p) -> p.getSourceType().getName().equals("fact"))
                .map(rec -> new DataRecord(DateUtils.format(rec.getDate(), DateUtils.RU_DATE_FORMAT), rec.getLiquidType().getName(), rec.getValue()))
                .collect(Collectors.groupingBy((c2) -> c2.date))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map((m) -> {
                    Map<String, Integer> l = m.getValue()
                            .stream()
                            .collect(Collectors.groupingBy(
                                    DataRecord::type,
                                    Collectors.summingInt(DataRecord::value)
                            ));
                    int total = l.values().stream().mapToInt(value -> value).sum();
                    return new ReportRow(m.getKey(), l, total);
                })
                .toList();
        return reportData;
    }

    private void printReport(List<ReportRow> reportData) {
        reportData.forEach(day -> {
                    System.out.println("Дата: " + day.date);
                    day.table.forEach((key, value) -> System.out.println("   "+key + ": " + value));
                    System.out.println("total: " + day.total);
                }
        );
        System.out.println(reportData);
    }

    private record DataRecord(String date, String type, int value) {    }
    private record ReportRow(String date, Map<String, Integer> table, int total) {    }
}
