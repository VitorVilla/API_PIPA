package com.api.pipa.controllers;


import com.api.pipa.dtos.TagRecordDto;
import com.api.pipa.entities.Tags;
import com.api.pipa.services.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tags")
public class TagController {

    @Autowired
    private TagService tagService;

    @PostMapping
    public ResponseEntity<Tags> saveTag(@RequestBody TagRecordDto tagRecordDto) {

        return ResponseEntity.status(HttpStatus.CREATED).body(tagService.saveTag(tagRecordDto));
    }

    @GetMapping
    public ResponseEntity<List<Tags>> getAllTag() {
        return ResponseEntity.status(HttpStatus.OK).body(tagService.getAllTag());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTag(@PathVariable Long id) {
        tagService.deleteTag(id);
        return ResponseEntity.status(HttpStatus.OK).body("Responsável deletado com sucesso!");

    }

}
