package com.demo.pingpoint.service;

import com.demo.pingpoint.model.Post;
import com.demo.pingpoint.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
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
}


