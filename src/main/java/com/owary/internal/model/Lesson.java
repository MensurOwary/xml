package com.owary.internal.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="lesson")
@Data
@NoArgsConstructor
public class Lesson {

    private static int count = 1;

    private long id;
    private String name;
    private Teacher teacher;

    public Lesson(String name, Teacher teacher) {
        this.id = count++;
        this.name = name;
        this.teacher = teacher;
    }
}
