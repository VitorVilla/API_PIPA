package com.api.pipa.repositories;

import com.api.pipa.entities.Imagens;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImagensRepository extends JpaRepository <Imagens, Long> {
}
