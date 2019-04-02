package com.javarush.task.examples.dateparsing;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Example {
    public static void main(String[] args) {
        String datestr = "22 04 1992";
        Date date = null;
        SimpleDateFormat sdf = new SimpleDateFormat("dd MM yy");
        try {
            date = sdf.parse(datestr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(date.toString());
    }
}
