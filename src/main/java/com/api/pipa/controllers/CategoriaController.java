package com.api.pipa.controllers;

import com.api.pipa.dtos.CategoriaRecordDto;
import com.api.pipa.entities.Categorias;
import com.api.pipa.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

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

    @GetMapping
    public ResponseEntity<List<Categorias>> getAllCategorias() {
        return ResponseEntity.status(HttpStatus.OK).body(categoriaService.getAllCategorias());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categorias> getCategoriaById(@PathVariable Long id) {
        Categorias categoria = categoriaService.getCategoriaById(id);
        if (categoria != null) {
            return ResponseEntity.status(HttpStatus.OK).body(categoria);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCategoria(@PathVariable Long id) {
        categoriaService.deleteCategoria(id);
        return ResponseEntity.status(HttpStatus.OK).body("Categoria deletada com sucesso!");
    }

}
