package ru.job4j.auth.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.job4j.auth.domain.Person;
import ru.job4j.auth.repository.PersonRepository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PersonService {
    private final PersonRepository personRepo;

    public Person save(Person person) {
        return personRepo.save(person);
    }

    public Optional<Person> findById(int id) {
        return personRepo.findById(id);
    }

    public List<Person> findAll() {
        return personRepo.findAll();
    }

    public void delete(int id) {
        personRepo.deleteById(id);
    }
}
