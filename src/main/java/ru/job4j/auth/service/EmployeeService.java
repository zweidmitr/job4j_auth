package ru.job4j.auth.service;

import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.job4j.auth.domain.Employee;
import ru.job4j.auth.domain.Person;
import ru.job4j.auth.repository.EmployeeRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final RestTemplate rest;
    private final EmployeeRepository employeeRepository;
    private static final String API = "http://localhost:8080/person/";
    private static final String API_ID = "http://localhost:8080/person/{id}";

    public List<Employee> findAll() {
        List<Employee> employees = new ArrayList<>();
        employeeRepository.findAll().forEach(employees::add);
        List<Person> accounts = rest.exchange(
                API, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<Person>>() {
                }).getBody();
        for (Employee employee : employees) {
            employee.setAccounts(accounts.stream()
                    .filter(person -> person.getEmployeeId() == employee.getId())
                    .collect(Collectors.toList()));
        }
        return employees;
    }

    public Person create(Person person) {
        return rest.postForObject(API, person, Person.class);
    }

    public void update(Person person) {
        rest.put(API, person);
    }

    public void delete(int id) {
        rest.delete(API_ID, id);
    }
}
