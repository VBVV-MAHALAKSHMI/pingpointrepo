package com.demo.pingpoint.repository;

import com.demo.pingpoint.model.EndPoint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EndPointRepository extends JpaRepository<EndPoint, Long> {
}


