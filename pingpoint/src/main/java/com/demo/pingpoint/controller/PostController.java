package com.demo.pingpoint.controller;

import com.demo.pingpoint.model.Post;
import com.demo.pingpoint.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    public List<Post> getAll() {
        return postService.getAll();
    }

    @GetMapping("/{id}")
    public Post getById(@PathVariable int id) {
        return postService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Post create(@RequestBody Post post) {
        return postService.create(post);
    }

    @PutMapping("/{id}")
    public Post update(@PathVariable int id, @RequestBody Post post) {
        return postService.update(id, post);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        postService.delete(id);
    }
}


