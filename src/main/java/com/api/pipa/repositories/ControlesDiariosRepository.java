package com.api.pipa.repositories;

import com.api.pipa.entities.ControlesDiarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ControlesDiariosRepository extends JpaRepository <ControlesDiarios, Long> {
}
