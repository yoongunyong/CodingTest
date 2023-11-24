package com.example.sinzi_CodingTest.post.repository;

import com.example.sinzi_CodingTest.post.entity.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<PostEntity,Long> {
}
