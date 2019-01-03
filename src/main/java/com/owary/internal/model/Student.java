package com.owary.internal.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

// it means the root of the XML document will be 'student'
// here 'root' is relative, since it can be the very root or any grouping of data
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

    // it is going to wrap the lessons property
    /**
     * If we won't put it, here's what's gonna happen
     * <lesson>...</lesson>
     * <lesson>...</lesson>
     * <lesson>...</lesson>
     *
     * However, using the Wrapper, it becomes
     * <lessons>
     *     <lesson>...</lesson>
     *     <lesson>...</lesson>
     * </lessons>
     * */
    // name - name of the node
    @XmlElement(name="lesson", type = Lesson.class)
    // name - the name of the outer wrapper
    @XmlElementWrapper(name = "lessons")
    public List<Lesson> getLessons() {
        return lessons;
    }
}
