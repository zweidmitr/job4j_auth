CREATE TABLE IF NOT EXISTS person
(
    id       SERIAL PRIMARY KEY,
    login    VARCHAR(2000),
    password VARCHAR(2000)
);

CREATE TABLE IF NOT EXISTS employee
(
    id         SERIAL PRIMARY KEY,
    name       VARCHAR(256),
    lastname   VARCHAR(256),
    tax_number VARCHAR(256),
    hiredate   TIMESTAMP
);

CREATE TABLE if not exists employee_person
(
    employee_id integer NOT NULL,
    person_id   integer NOT NULL,
    PRIMARY KEY (employee_id, person_id),
    FOREIGN KEY (employee_id) REFERENCES employee,
    FOREIGN KEY (person_id) REFERENCES person
);


drop table person cascade;
drop table employee cascade;

INSERT INTO employee(name, lastname, tax_number, hiredate)
VALUES ('Petr', 'Pars', '7701215046', '2022-07-12 21:51'),
       ('Mitr', 'Zw', '0123456789', '2022-07-12 21:52');

INSERT INTO person(login, password)
VALUES ('parsentev', '123');