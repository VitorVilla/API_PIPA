package com.api.pipa.repositories;

import com.api.pipa.entities.Alunos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunosRepository extends JpaRepository <Alunos, Long> {
}
