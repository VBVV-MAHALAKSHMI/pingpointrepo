package com.demo.pingpoint.service;

import com.demo.pingpoint.model.EndPoint;
import com.demo.pingpoint.model.Person;
import com.demo.pingpoint.repository.EndPointRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class EndPointService {

    private final EndPointRepository endPointRepository;

    public EndPointService(EndPointRepository endPointRepository) {
        this.endPointRepository = endPointRepository;
    }

    public List<EndPoint> getAll() {
        return endPointRepository.findAll();
    }

    public EndPoint getById(Long id) {
        return endPointRepository.findById(id).orElseThrow();
    }

    public EndPoint create(EndPoint endPoint) {
        endPoint.setId(null);
        return endPointRepository.save(endPoint);
    }

    public EndPoint update(Long id, EndPoint updated) {
        EndPoint existing = getById(id);
        existing.setName(updated.getName());
        return endPointRepository.save(existing);
    }

    public void delete(Long id) {
        EndPoint existing = getById(id);
        endPointRepository.delete(existing);
    }

    public Set<Person> getSubscribers(Long id) {
        return getById(id).getSubscribers();
    }
}


