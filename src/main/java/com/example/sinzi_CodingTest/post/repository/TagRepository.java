package com.example.sinzi_CodingTest.post.repository;

import com.example.sinzi_CodingTest.post.entity.TagEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<TagEntity,Long> {
}
