package ru.job4j.auth.domain;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "employee")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    private String name;
    private String lastname;
    private long taxNumber;
    @Column(name = "hiredate")
    private Date hiredate = new Date(System.currentTimeMillis());
    @Transient
    private List<Person> accounts;
}
