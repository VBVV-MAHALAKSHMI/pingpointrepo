package com.demo.pingpoint.service;

import com.demo.pingpoint.model.Person;
import com.demo.pingpoint.model.EndPoint;
import com.demo.pingpoint.repository.EndPointRepository;
import com.demo.pingpoint.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class PersonService {

    private final PersonRepository personRepository;
    private final EndPointRepository endPointRepository;

    public PersonService(PersonRepository personRepository, EndPointRepository endPointRepository) {
        this.personRepository = personRepository;
        this.endPointRepository = endPointRepository;
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

    public Person subscribeToEndpoint(int userId, Long endpointId) {
        Person person = getById(userId);
        EndPoint endpoint = endPointRepository.findById(endpointId).orElseThrow();
        person.getSubscribedEndpoints().add(endpoint);
        return personRepository.save(person);
    }

    public Set<EndPoint> getSubscribedEndpoints(int userId) {
        return getById(userId).getSubscribedEndpoints();
    }
}


