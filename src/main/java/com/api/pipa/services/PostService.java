package com.api.pipa.services;

import com.api.pipa.dtos.PostRecordDto;
import com.api.pipa.entities.Imagens;
import com.api.pipa.entities.Posts;
import com.api.pipa.entities.Tags;
import com.api.pipa.repositories.CategoriasRepository;
import com.api.pipa.repositories.ImagensRepository;
import com.api.pipa.repositories.PostsRepository;
import com.api.pipa.repositories.TagsRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Service
public class PostService {

    @Autowired
    private PostsRepository postsRepository;
    @Autowired
    private ImagensRepository imagensRepository;
    @Autowired
    private CategoriasRepository categoriasRepository;
    @Autowired
    private TagsRepository tagsRepository;

    @Transactional
    public Posts savePost(PostRecordDto postRecordDto, MultipartFile file) {

        Posts post = new Posts();
        Imagens imagens = new Imagens();

        post.setTitulo(postRecordDto.titulo());
        post.setDescricao(postRecordDto.descricao());
        post.setCategoria(categoriasRepository.findById(postRecordDto.categoria_id()).orElseThrow());

        Set<Tags> tags = new HashSet<>(tagsRepository.findAllById(postRecordDto.tagIds()));
        post.setTags(tags);

        try {
            imagens.setImagem("data:image/png;base64," + imagensRepository.imagemEncoder(file.getBytes()));
            imagens.setData(new Timestamp(System.currentTimeMillis()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return postsRepository.save(post);
    }

}
