package com.demo.pingpoint.controller;

import com.demo.pingpoint.model.Person;
import com.demo.pingpoint.service.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/persons")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    // Get all users
    @GetMapping
    public List<Person> getAll() {
        return personService.getAll();
    }

    // Get user by ID
    @GetMapping("/{id}")
    public Person getById(@PathVariable int id) {
        return personService.getById(id);
    }

    // Create user
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Person create(@RequestBody Person person) {
        return personService.create(person);
    }

    // Update user
    @PutMapping("/{id}")
    public Person update(@PathVariable int id, @RequestBody Person person) {
        return personService.update(id, person);
    }

    // Delete user
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        personService.delete(id);
    }

    // Subscribe user to endpoint
    @PostMapping("/{userId}/subscribe/{endpointId}")
    public Person subscribe(@PathVariable int userId, @PathVariable Long endpointId) {
        return personService.subscribeToEndpoint(userId, endpointId);
    }

    // Get endpoints subscribed by user
    @GetMapping("/{userId}/endpoints")
    public Set<com.demo.pingpoint.model.EndPoint> getSubscribed(@PathVariable int userId) {
        return personService.getSubscribedEndpoints(userId);
    }
}


