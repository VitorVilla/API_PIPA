package com.api.pipa.repositories;

import com.api.pipa.entities.Responsaveis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResponsaveisRepository extends JpaRepository <Responsaveis, Long> {
}
