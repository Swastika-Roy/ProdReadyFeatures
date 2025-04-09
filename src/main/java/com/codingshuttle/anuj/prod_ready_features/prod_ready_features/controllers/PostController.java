package com.codingshuttle.anuj.prod_ready_features.prod_ready_features.controllers;

import com.codingshuttle.anuj.prod_ready_features.prod_ready_features.dto.PostDTO;
import com.codingshuttle.anuj.prod_ready_features.prod_ready_features.repositories.PostRepository;
import com.codingshuttle.anuj.prod_ready_features.prod_ready_features.services.PostService;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/posts")
//@RequiredArgsConstructor
public class PostController {

    @Autowired
    private PostRepository postRepository;

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    public List<PostDTO> getAllPosts(){
        return postService.getAllPosts();
    }

    @PostMapping("/{postId}")
    public PostDTO getPostById(@PathVariable Long postId){
        return postService.getPostById(postId);
    }

    @PostMapping
    public PostDTO createNewPost(@RequestBody PostDTO inputPost){
        return postService.createNewPost(inputPost);
    }

    @PutMapping("{postId}")
    public PostDTO updatePost(@RequestBody PostDTO inputPost,@PathVariable Long postId){
        return postService.updatePost(inputPost,postId);
    }


}
