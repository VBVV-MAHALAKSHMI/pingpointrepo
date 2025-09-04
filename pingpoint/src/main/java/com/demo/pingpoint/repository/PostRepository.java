package com.demo.pingpoint.repository;

import com.demo.pingpoint.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {
    java.util.List<Post> findByPersonId(int personId);
    java.util.List<Post> findByEndpointId(Long endpointId);
}


