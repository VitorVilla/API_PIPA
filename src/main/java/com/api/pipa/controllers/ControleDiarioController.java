package com.api.pipa.controllers;


import com.api.pipa.dtos.ControleDiarioRecordDto;
import com.api.pipa.entities.ControlesDiarios;
import com.api.pipa.services.ControleDiarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/controle")
public class ControleDiarioController {

    @Autowired
    ControleDiarioService controleDiarioService;

    @PostMapping
    public ResponseEntity<ControlesDiarios> saveSala(@RequestBody ControleDiarioRecordDto controleDiarioRecordDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(controleDiarioService.save(controleDiarioRecordDto));
    }

    @GetMapping
    public ResponseEntity<List<ControlesDiarios>> getAllControleDiario() {
        return ResponseEntity.status(HttpStatus.OK).body(controleDiarioService.getAllControleDiario());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ControlesDiarios> getControleDiarioById(@PathVariable Long id) {
        ControlesDiarios controleDiario = controleDiarioService.getControleDiarioById(id);
        if (controleDiario != null) {
            return ResponseEntity.status(HttpStatus.OK).body(controleDiario);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteControleDiario(@PathVariable Long id) {
        controleDiarioService.deleteControleDiario(id);
        return ResponseEntity.status(HttpStatus.OK).body("Controle Diario deletado com sucesso!");
    }
}
