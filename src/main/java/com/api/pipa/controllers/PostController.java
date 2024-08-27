package com.api.pipa.controllers;

import com.api.pipa.dtos.PostRecordDto;
import com.api.pipa.entities.Posts;
import com.api.pipa.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    PostService postService;

    @PostMapping
    public ResponseEntity<Posts> savePost (@RequestPart("data") PostRecordDto postRecordDto,
                                           @RequestPart("file") MultipartFile file) {

        return ResponseEntity.status(HttpStatus.CREATED).body(postService.savePost(postRecordDto, file));
    }

    @GetMapping
    public ResponseEntity<List<Posts>> getAllPost() {
        return ResponseEntity.status(HttpStatus.OK).body(postService.getAllPost());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePost(@PathVariable Long id) {
        postService.deletePost(id);
        return ResponseEntity.status(HttpStatus.OK).body("Post deletado com sucesso!");
    }
}
