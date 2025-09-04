package com.demo.pingpoint.controller;

import com.demo.pingpoint.model.Post;
import com.demo.pingpoint.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    // Get all posts
    @GetMapping
    public List<Post> getAll() {
        return postService.getAll();
    }

    // Get post by ID
    @GetMapping("/{id}")
    public Post getById(@PathVariable int id) {
        return postService.getById(id);
    }

    // Create post for a user and endpoint
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Post create(@RequestBody com.demo.pingpoint.dto.CreatePostRequest request) {
        return postService.createForUserAndEndpoint(
                request.getContent(),
                request.getUserId(),
                request.getEndpointId()
        );
    }

    // Update a post
    @PutMapping("/{id}")
    public Post update(@PathVariable int id, @RequestBody Post post) {
        return postService.update(id, post);
    }

    // Delete a post
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        postService.delete(id);
    }

    // Get posts of a user
    @GetMapping("/users/{userId}")
    public List<Post> getPostsByUser(@PathVariable int userId) {
        return postService.getPostsByUser(userId);
    }

    // Get posts of an endpoint
    @GetMapping("/endpoints/{endpointId}")
    public List<Post> getPostsByEndpoint(@PathVariable Long endpointId) {
        return postService.getPostsByEndpoint(endpointId);
    }
}


