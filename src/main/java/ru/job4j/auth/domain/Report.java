package ru.job4j.auth.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Table;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Report {
    private int id;
    private String name;
    private Timestamp created;
    private Person person;

    public static Report of(int id, String name, Person person) {
        Report r = new Report();
        r.setId(id);
        r.setName(name);
        r.setPerson(person);
        r.setCreated(new Timestamp(System.currentTimeMillis()));
        return r;
    }
}
