package com.demo.pingpoint.service;

import com.demo.pingpoint.model.Post;
import com.demo.pingpoint.model.Person;
import com.demo.pingpoint.model.EndPoint;
import com.demo.pingpoint.repository.PersonRepository;
import com.demo.pingpoint.repository.EndPointRepository;
import com.demo.pingpoint.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    private final PostRepository postRepository;
    private final PersonRepository personRepository;
    private final EndPointRepository endPointRepository;

    public PostService(PostRepository postRepository, PersonRepository personRepository, EndPointRepository endPointRepository) {
        this.postRepository = postRepository;
        this.personRepository = personRepository;
        this.endPointRepository = endPointRepository;
    }

    public List<Post> getAll() {
        return postRepository.findAll();
    }

    public Post getById(int id) {
        return postRepository.findById(id).orElseThrow();
    }

    public Post create(Post post) {
        post.setId(0);
        return postRepository.save(post);
    }

    public Post update(int id, Post updated) {
        Post existing = getById(id);
        existing.setContent(updated.getContent());
        existing.setPerson(updated.getPerson());
        existing.setEndpoint(updated.getEndpoint());
        return postRepository.save(existing);
    }

    public void delete(int id) {
        Post existing = getById(id);
        postRepository.delete(existing);
    }

    public Post createForUserAndEndpoint(String content, int userId, Long endpointId) {
        Person person = personRepository.findById(userId).orElseThrow();
        EndPoint endpoint = endPointRepository.findById(endpointId).orElseThrow();
        Post post = Post.builder()
                .content(content)
                .person(person)
                .endpoint(endpoint)
                .build();
        return postRepository.save(post);
    }

    public List<Post> getPostsByUser(int userId) {
        return postRepository.findByPersonId(userId);
    }

    public List<Post> getPostsByEndpoint(Long endpointId) {
        return postRepository.findByEndpointId(endpointId);
    }
}


