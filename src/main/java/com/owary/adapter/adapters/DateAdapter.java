package com.owary.adapter.adapters;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.util.Date;

public class DateAdapter extends XmlAdapter<String, Date> {
    @Override
    public Date unmarshal(String v) throws Exception {
        long millis = Long.parseLong(v);
        System.out.println(millis);
        return new Date(millis);
    }

    @Override
    public String marshal(Date v) throws Exception {
        return String.valueOf(v.getTime());
    }
}
