package com.demo.pingpoint.controller;

import com.demo.pingpoint.model.EndPoint;
import com.demo.pingpoint.service.EndPointService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/endpoints")
public class EndPointController {

    private final EndPointService endPointService;

    public EndPointController(EndPointService endPointService) {
        this.endPointService = endPointService;
    }

    // Get all endpoints
    @GetMapping
    public List<EndPoint> getAll() {
        return endPointService.getAll();
    }

    // Get endpoint by ID
    @GetMapping("/{id}")
    public EndPoint getById(@PathVariable Long id) {
        return endPointService.getById(id);
    }

    // Create endpoint
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EndPoint create(@RequestBody EndPoint endPoint) {
        return endPointService.create(endPoint);
    }

    // Update endpoint
    @PutMapping("/{id}")
    public EndPoint update(@PathVariable Long id, @RequestBody EndPoint endPoint) {
        return endPointService.update(id, endPoint);
    }

    // Delete endpoint
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        endPointService.delete(id);
    }

    // Get all subscribers of an endpoint
    @GetMapping("/{id}/subscribers")
    public Set<com.demo.pingpoint.model.Person> getSubscribers(@PathVariable Long id) {
        return endPointService.getSubscribers(id);
    }
}


