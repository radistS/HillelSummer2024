package com.hillel.lesson_19.logger;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTransformer {

    public static String convert(){
        String pattern = "yyyy-MM-dd hh:mm:sss";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        return simpleDateFormat.format(new Date(System.currentTimeMillis()));
    }

}
