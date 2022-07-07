package ru.job4j.auth.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "person")
@Data
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String login;
    private String password;

}
