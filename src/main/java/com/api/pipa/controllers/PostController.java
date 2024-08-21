package com.api.pipa.controllers;

import com.api.pipa.dtos.CategoriaRecordDto;
import com.api.pipa.dtos.PostRecordDto;
import com.api.pipa.entities.Categorias;
import com.api.pipa.entities.Posts;
import com.api.pipa.services.CategoriaService;
import com.api.pipa.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

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
}
