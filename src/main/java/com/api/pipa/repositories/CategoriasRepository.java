package com.api.pipa.repositories;

import com.api.pipa.entities.Categorias;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriasRepository extends JpaRepository <Categorias, Long> {
}
