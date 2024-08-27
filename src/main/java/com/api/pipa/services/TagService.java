package com.api.pipa.services;

import com.api.pipa.dtos.TagRecordDto;
import com.api.pipa.entities.Tags;
import com.api.pipa.repositories.TagsRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagService {

    @Autowired
    TagsRepository tagsRepository;

    @Transactional
    public Tags saveTag (TagRecordDto tagRecordDto) {

        Tags tags = new Tags();
        tags.setTitulo(tagRecordDto.titulo());

        return tagsRepository.save(tags);
    }

    @Transactional
    public void deleteTag(Long id){
        tagsRepository.deleteById(id);
    }

    public List<Tags> getAllTag() {
        return tagsRepository.findAll();
    }
}
