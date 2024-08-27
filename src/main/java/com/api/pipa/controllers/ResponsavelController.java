package com.api.pipa.controllers;


import com.api.pipa.dtos.ResponsavelRecordDto;
import com.api.pipa.entities.Responsaveis;
import com.api.pipa.services.ResponsavelService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/responsavel")
public class ResponsavelController {

    @Autowired
    private ResponsavelService responsavelService;

    @PostMapping
    public ResponseEntity<Responsaveis> saveResponsavel(@RequestBody @Valid ResponsavelRecordDto ResponsavelRecordDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(responsavelService.saveResposavel(ResponsavelRecordDto));
    }

    @GetMapping
    public ResponseEntity<List<Responsaveis>> getAllResponsavel() {
        return ResponseEntity.status(HttpStatus.OK).body(responsavelService.getAllResponsavel());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteResponsavel(@PathVariable Long id) {
        responsavelService.deleteResponsavel(id);
        return ResponseEntity.status(HttpStatus.OK).body("Responsável deletado com sucesso!");

    }
}