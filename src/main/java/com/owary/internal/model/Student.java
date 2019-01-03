package com.owary.internal.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name="student")
@Data
@NoArgsConstructor
public class Student {

    private static int count = 1;

    private long id;
    private String name;
    private String surname;

    private List<Lesson> lessons;

    public Student(String name, String surname) {
        this.id = count++;
        this.name = name;
        this.surname = surname;
    }

    @XmlElement(name="lesson", type = Lesson.class)
    @XmlElementWrapper(name = "lessons")
    public List<Lesson> getLessons() {
        return lessons;
    }
}
