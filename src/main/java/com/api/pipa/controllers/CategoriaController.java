package com.api.pipa.controllers;

import com.api.pipa.dtos.CategoriaRecordDto;
import com.api.pipa.entities.Categorias;
import com.api.pipa.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    CategoriaService categoriaService;

    @PostMapping
    public ResponseEntity<Categorias> saveCategoria (@RequestPart("data") CategoriaRecordDto categoriaRecordDto,
                                                     @RequestPart("file") MultipartFile file) {

        return ResponseEntity.status(HttpStatus.CREATED).body(categoriaService.saveCategoria(categoriaRecordDto, file));
    }
}
