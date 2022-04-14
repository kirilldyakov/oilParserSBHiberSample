package com.example.oil.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class DateUtils {
    public static String RU_DATE_FORMAT = "dd.MM.yyyy";
    public static String EN_DATE_FORMAT = "yyyy-MM-dd";

    public static Date getRandomDate(){
        int MONTH = 4;
        int YEAR =2022;
        int MAX_DATE = 10;

        Random random = new Random();
        int day = random.nextInt(MAX_DATE)+1;

        Calendar calendar = Calendar.getInstance();
        calendar.set(YEAR, MONTH, day);
        return calendar.getTime();
    }

    public static String format( Date date, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }
}
