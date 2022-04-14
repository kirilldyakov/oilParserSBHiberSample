package com.example.oil.service;


import com.example.oil.repository.CalendarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static com.example.oil.utils.DateUtils.*;


@Service
public class CalendarService {

    @Autowired
    CalendarRepository calendarRepository;

    public void start(){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date startDate = null;
        Date endDate = null;
        try {
            startDate = formatter.parse("2022-05-01");
            endDate = formatter.parse("2022-06-01");
        } catch (ParseException e) {
            e.printStackTrace();
        }


        Calendar start = Calendar.getInstance();
        start.setTime(startDate);
        Calendar end = Calendar.getInstance();
        end.setTime(endDate);

        for (Date date = start.getTime(); start.before(end); start.add(Calendar.DATE, 1), date = start.getTime()) {
            com.example.oil.model.Calendar calendar = new com.example.oil.model.Calendar ();
            calendar.setDate(date);
            calendar.setRuDate(format(date, RU_DATE_FORMAT));
            calendar.setEnDate(format(date, EN_DATE_FORMAT));
            calendarRepository.save(calendar);
            System.out.println(date);
        }
    }

}
