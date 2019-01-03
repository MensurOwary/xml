package com.owary.internal;

import com.owary.internal.model.Lesson;
import com.owary.internal.model.Student;
import com.owary.internal.model.Teacher;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.List;

public class MainInternal {

    /**
     * Purpose here is to generate an XML using JAXB and later on unmarshall it using the same context
     */

    public static void main(String[] args) throws JAXBException, FileNotFoundException {
        // Preparation
        Teacher teach1 = new Teacher("Gilbert", "Strang");
        Teacher teach2 = new Teacher("Harrison", "Wiedmann");

        Lesson calculus = new Lesson("Calculus", teach1);
        Lesson linear = new Lesson("Linear Algebra", teach1);
        Lesson dataStructures = new Lesson("Data Structures", teach2);
        Lesson algorithms = new Lesson("Algorithms", teach2);

        List<Lesson> block1 = Arrays.asList(calculus, dataStructures, algorithms);
        List<Lesson> block2 = Arrays.asList(algorithms, dataStructures, linear);

        Student student1 = new Student("John", "Doe");student1.setLessons(block1);
        Student student2 = new Student("Jane", "Done");student2.setLessons(block2);

        // JAXB
        // first we have to initialize context and marshaller
        JAXBContext context = JAXBContext.newInstance(Student.class);
        // Marshaller to bind the XML data to the class instance
        Marshaller marshaller = context.createMarshaller();
        // output should be formatted correctly (e.g correct indentation)
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        // Marshalling step
        // first argument  - the object to marshall
        // second argument - how it should be outputted
        marshaller.marshal(student1, System.out);
        // first argument  - the object to marshall
        // second argument - a file which is gonna be used to generate an XML
        marshaller.marshal(student1, new File("./student_ex.xml"));

        // Unmarshalling
        // first we need to create an unmarshaller using the context which is
        // initialized based on the Student class
        Unmarshaller unmarshaller = context.createUnmarshaller();
        // retrieve the Student object using the unmarshal method
        // we need to pass an XML file to read from
        Student unmarshalled = (Student) unmarshaller.unmarshal(new FileReader("./student_ex.xml"));
        // print it
        System.out.println(unmarshalled);

    }

}
