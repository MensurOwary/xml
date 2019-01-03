package com.owary.external.model;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name="book")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class Book {

    private String title;
    private List<String> author;
    private Integer year;
    private Double price;
    @XmlAttribute
    private String category;

    @Override
    public String toString() {
        return String.format("title : %s\nyear : %d\nprice : %.2f\nauthors : %s\ncategory : %s",
                title, year, price, author, category);
    }
}
