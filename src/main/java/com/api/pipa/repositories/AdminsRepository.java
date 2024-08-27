package com.api.pipa.repositories;

import com.api.pipa.entities.Admins;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminsRepository extends JpaRepository<Admins, Long> {
}
