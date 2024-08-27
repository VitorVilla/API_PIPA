package com.api.pipa.services;

import com.api.pipa.dtos.CategoriaRecordDto;
import com.api.pipa.entities.Alunos;
import com.api.pipa.entities.Categorias;
import com.api.pipa.entities.Imagens;
import com.api.pipa.repositories.CategoriasRepository;
import com.api.pipa.repositories.ImagensRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

@Service
public class CategoriaService {

    @Autowired
    CategoriasRepository categoriasRepository;

    @Autowired
    ImagensRepository imagensRepository;

    @Transactional
    public Categorias saveCategoria(CategoriaRecordDto categoriaRecordDto, MultipartFile file) {

        Categorias categoria = new Categorias();
        Imagens imagens = new Imagens();

        categoria.setTitulo(categoriaRecordDto.titulo());

        try {
            imagens.setImagem("data:image/png;base64," + imagensRepository.imagemEncoder(file.getBytes()));
            imagens.setData(new Timestamp(System.currentTimeMillis()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        imagensRepository.save(imagens);

        categoria.setImagem(imagens);

        return categoriasRepository.save(categoria);
    }

    @Transactional
    public void deleteCategoria(Long id){
        categoriasRepository.deleteById(id);
    }

    public List<Categorias> getAllCategorias() {
        return categoriasRepository.findAll();
    }

}
