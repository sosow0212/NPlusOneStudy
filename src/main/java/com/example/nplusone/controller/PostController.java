package com.example.nplusone.controller;

import com.example.nplusone.dto.post.PostSaveRequestDto;
import com.example.nplusone.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class PostController {
    private final PostService postService;

    @PostMapping("/posts")
    public ResponseEntity<String> savePost(@RequestBody PostSaveRequestDto req) {
        postService.savePost(req);
        return new ResponseEntity<>("포스트 저장 성공", HttpStatus.CREATED);
    }

    @GetMapping("/posts")
    public ResponseEntity<?> readAllPosts() {
        return new ResponseEntity<>(postService.readAllPosts(), HttpStatus.OK);
    }

    @GetMapping("/posts/no/{id}")
    public ResponseEntity<?> readPost(@PathVariable("id") Long id) {
        return new ResponseEntity<>(postService.readPost(id), HttpStatus.OK);
    }

    @GetMapping("/posts/{writer}")
    public ResponseEntity<?> readMyPost(@PathVariable("writer") String writer) {
        return new ResponseEntity<>(postService.readMyPosts(writer), HttpStatus.OK);
    }
}
