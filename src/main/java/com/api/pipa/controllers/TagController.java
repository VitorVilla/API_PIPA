package com.api.pipa.controllers;


import com.api.pipa.dtos.TagRecordDto;
import com.api.pipa.entities.Tags;
import com.api.pipa.services.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tags")
public class TagController {

    @Autowired
    private TagService tagService;

    @PostMapping
    public ResponseEntity<Tags> saveTag(@RequestBody TagRecordDto tagRecordDto) {

        return ResponseEntity.status(HttpStatus.CREATED).body(tagService.saveTag(tagRecordDto));
    }

}
