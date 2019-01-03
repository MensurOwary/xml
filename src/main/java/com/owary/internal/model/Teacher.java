package com.owary.internal.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="teacher")
@Data
@NoArgsConstructor
public class Teacher {

    private static int count = 1;

    private long id;
    private String name;
    private String surname;

    public Teacher(String name, String surname) {
        this.id = count++;
        this.name = name;
        this.surname = surname;
    }
}
