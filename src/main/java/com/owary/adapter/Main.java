package com.owary.adapter;

import com.owary.adapter.model.Ticket;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.time.LocalDate;
import java.util.Date;

public class Main {

    public static void main(String[] args) throws JAXBException {
        // preparation
        final String FILE_LOCATION = "./ticket_output.xml";

        LocalDate ld = LocalDate.of(1997, 11, 13);
        Date date = new Date();
        Ticket ticket = new Ticket();
        ticket.setName("Hollywood Undead Concert");
        ticket.setEventDate(ld);
        ticket.setDateCreated(date);

        // Initially, create JAXB context based on the class Ticket
        JAXBContext ctx = JAXBContext.newInstance(Ticket.class);
        // Create a marshaller to marshal the object to the XML format
        Marshaller marshaller = ctx.createMarshaller();
        // set the property as such to have an output with correct indentation
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        // do the marshalling to print out to the console
        marshaller.marshal(ticket, System.out);
        // do the marshalling to write to the file
        marshaller.marshal(ticket, new File(FILE_LOCATION));

        // create the unmarshaller to unmarshal the xml file that was just created
        Unmarshaller unmarshaller = ctx.createUnmarshaller();
        // generate the Ticket object out of the file
        Ticket ticket_generated = (Ticket) unmarshaller.unmarshal(new File(FILE_LOCATION));
        // check if the generated and the initial objects are equal
        // ideally the result should be True
        System.out.println(ticket_generated.equals(ticket));
    }

}
