package com.demo.pingpoint.service;

import com.demo.pingpoint.model.Person;
import com.demo.pingpoint.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> getAll() {
        return personRepository.findAll();
    }

    public Person getById(int id) {
        return personRepository.findById(id).orElseThrow();
    }

    public Person create(Person person) {
        person.setId(0);
        return personRepository.save(person);
    }

    public Person update(int id, Person updated) {
        Person existing = getById(id);
        existing.setUsername(updated.getUsername());
        existing.setEmail(updated.getEmail());
        return personRepository.save(existing);
    }

    public void delete(int id) {
        Person existing = getById(id);
        personRepository.delete(existing);
    }
}


