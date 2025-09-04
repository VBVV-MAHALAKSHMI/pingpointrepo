package com.demo.pingpoint.controller;

import com.demo.pingpoint.model.EndPoint;
import com.demo.pingpoint.service.EndPointService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/endpoints")
public class EndPointController {

    private final EndPointService endPointService;

    public EndPointController(EndPointService endPointService) {
        this.endPointService = endPointService;
    }

    @GetMapping
    public List<EndPoint> getAll() {
        return endPointService.getAll();
    }

    @GetMapping("/{id}")
    public EndPoint getById(@PathVariable Long id) {
        return endPointService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EndPoint create(@RequestBody EndPoint endPoint) {
        return endPointService.create(endPoint);
    }

    @PutMapping("/{id}")
    public EndPoint update(@PathVariable Long id, @RequestBody EndPoint endPoint) {
        return endPointService.update(id, endPoint);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        endPointService.delete(id);
    }
}


