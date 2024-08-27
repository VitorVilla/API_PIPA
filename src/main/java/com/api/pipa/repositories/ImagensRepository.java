package com.api.pipa.repositories;

import com.api.pipa.entities.Imagens;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Base64;

@Repository
public interface ImagensRepository extends JpaRepository<Imagens, Long> {

    default String imagemEncoder(byte[] file) {
        return Base64.getEncoder().encodeToString(file);
    }


}
