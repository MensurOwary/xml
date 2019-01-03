package com.owary.external.model;

import lombok.Data;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "bookstore")
@Data
public class Bookstore {
    private List<Book> book;

    @Override
    public String toString() {
        return book.stream()
                .map(Book::toString)
                .reduce("", (acc, el)->acc+el+"\n\n");
    }
}
