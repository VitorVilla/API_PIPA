package com.api.pipa.controllers;


import com.api.pipa.dtos.ProfessorRecordDto;
import com.api.pipa.entities.Professores;
import com.api.pipa.services.ProfessorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/professores")
public class ProfessoresController {

    @Autowired
    private ProfessorService professorService;

    @GetMapping
    public ResponseEntity<List<Professores>> getAllProfessores() {
        return ResponseEntity.status(HttpStatus.OK).body(professorService.getAllProfessores());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Professores> updateProfessor(@PathVariable Long id, @RequestBody @Valid ProfessorRecordDto professorRecordDto) {
        Professores professor = professorService.updateProfessor(id, professorRecordDto);
        if (professor != null) {
            return ResponseEntity.status(HttpStatus.OK).body(professor);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Professores> getProfessorByID(@PathVariable Long id) {
        Professores professor = professorService.getProfessor(id);
        if (professor != null) {
            return ResponseEntity.status(HttpStatus.OK).body(professor);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProfessor(@PathVariable Long id) {
        professorService.deleteAluno(id);
        return ResponseEntity.status(HttpStatus.OK).body("Professor deletado com sucesso.");
    }

}
