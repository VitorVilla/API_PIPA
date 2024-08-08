package com.api.pipa.repositories;

import com.api.pipa.entities.Tags;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagsRepository extends JpaRepository <Tags, Long> {
}
