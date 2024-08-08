package com.api.pipa.repositories;

import com.api.pipa.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository <Users, Long> {
}
