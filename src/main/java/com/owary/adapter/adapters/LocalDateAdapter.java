package com.owary.adapter.adapters;


import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.time.LocalDate;
import java.util.Arrays;

public class LocalDateAdapter extends XmlAdapter<String, LocalDate> {

    @Override
    public LocalDate unmarshal(String v) throws Exception {
        /***
         * String format - "yyyy-MM-dd"
         */
        String[] split = v.split("\\-");
        System.out.println(Arrays.toString(split));
        int year = Integer.parseInt(split[0]);
        int month = Integer.parseInt(split[1]);
        int day = Integer.parseInt(split[2]);
        return LocalDate.of(year, month, day);
    }

    @Override
    public String marshal(LocalDate v) throws Exception {
        int year = v.getYear();
        int month = v.getMonthValue();
        int day = v.getDayOfMonth();
        return String.format("%d-%d-%d", year, month, day);
    }
}
