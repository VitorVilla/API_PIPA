package com.api.pipa.controllers;


import com.api.pipa.dtos.AlunoRecordDto;
import com.api.pipa.dtos.ResponsavelRecordDto;
import com.api.pipa.entities.Alunos;
import com.api.pipa.entities.Responsaveis;
import com.api.pipa.services.AlunoService;
import com.api.pipa.services.ResponsavelService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/responsavel")
public class ResponsavelController {

    @Autowired
    private ResponsavelService responsavelService;

    @PostMapping
    public ResponseEntity<Responsaveis> saveResponsavel (@RequestBody @Valid ResponsavelRecordDto ResponsavelRecordDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(responsavelService.saveResposavel(ResponsavelRecordDto));
    }
}