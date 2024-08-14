package com.api.pipa.controllers;


import com.api.pipa.dtos.AlunoRecordDto;
import com.api.pipa.entities.Alunos;
import com.api.pipa.services.AlunoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/alunos")
public class AlunosController {

    @Autowired
    private AlunoService alunoService;

    @PostMapping
    public ResponseEntity<Alunos> saveAlunos(@RequestBody @Valid AlunoRecordDto alunoRecordDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(alunoService.saveAluno(alunoRecordDto));
    }
}
