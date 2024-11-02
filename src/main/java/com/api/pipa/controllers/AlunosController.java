package com.api.pipa.controllers;


import com.api.pipa.dtos.AlunoRecordDto;
import com.api.pipa.entities.Alunos;
import com.api.pipa.services.AlunoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunosController {

    @Autowired
    private AlunoService alunoService;

    @PostMapping
    public ResponseEntity<Alunos> saveAlunos(@RequestBody @Valid AlunoRecordDto alunoRecordDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(alunoService.saveAluno(alunoRecordDto));
    }

    @GetMapping
    public ResponseEntity<List<Alunos>> getAllAlunos() {
        return ResponseEntity.status(HttpStatus.OK).body(alunoService.getAllAlunos());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Alunos> updateAluno(@PathVariable Long id, @RequestBody @Valid AlunoRecordDto alunoRecordDto) {
        Alunos aluno = alunoService.updateAluno(id, alunoRecordDto);
        if (aluno != null) {
            return ResponseEntity.status(HttpStatus.OK).body(aluno);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Alunos> getAlunoById(@PathVariable Long id) {
        Alunos aluno = alunoService.getAluno(id);
        if (aluno != null) {
            return ResponseEntity.status(HttpStatus.OK).body(aluno);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAluno(@PathVariable Long id) {
        alunoService.deleteAluno(id);
        return ResponseEntity.status(HttpStatus.OK).body("Aluno deletado com sucesso.");
    }

}
