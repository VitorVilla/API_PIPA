package com.api.pipa.repositories;

import com.api.pipa.entities.Enderecos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<Enderecos, Long> {
}
