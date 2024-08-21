package com.api.pipa.repositories;

import com.api.pipa.entities.Posts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepository extends JpaRepository<Posts, Long> {
}
