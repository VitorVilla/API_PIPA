package com.api.pipa.controllers;

import com.api.pipa.dtos.SalaRecordDto;
import com.api.pipa.entities.Salas;
import com.api.pipa.services.SalaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sala")
public class SalasController {

    @Autowired
    SalaService salaService;

    @PostMapping
    public ResponseEntity<Salas> saveSala(@RequestBody SalaRecordDto salaRecordDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(salaService.saveSala(salaRecordDto));
    }

    @GetMapping
    public ResponseEntity<List<Salas>> getAllSala() {
        return ResponseEntity.status(HttpStatus.OK).body(salaService.getAllSala());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSala(@PathVariable Long id) {
        salaService.deleteSala(id);
        return ResponseEntity.status(HttpStatus.OK).body("Sala deletada com sucesso!");

    }

}
