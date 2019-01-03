package com.owary.adapter.model;

import com.owary.adapter.adapters.DateAdapter;
import com.owary.adapter.adapters.LocalDateAdapter;
import lombok.Data;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

@XmlType(propOrder = {"name", "eventDate", "dateCreated"})
@XmlRootElement(name = "ticket")
@Data
public class Ticket {

    private String name;
    private LocalDate eventDate;
    private Date dateCreated;

    @XmlElement(name = "EventName")
    public void setName(String name) {
        this.name = name;
    }

    @XmlElement(name = "EventDate")
    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    public void setEventDate(LocalDate eventDate) {
        this.eventDate = eventDate;
    }

    @XmlElement(name = "GeneratedWhen")
    @XmlJavaTypeAdapter(DateAdapter.class)
    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ticket)) return false;
        Ticket ticket = (Ticket) o;
        return Objects.equals(getName(), ticket.getName()) &&
                Objects.equals(getEventDate(), ticket.getEventDate()) &&
                Objects.equals(getDateCreated(), ticket.getDateCreated());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getEventDate(), getDateCreated());
    }
}
