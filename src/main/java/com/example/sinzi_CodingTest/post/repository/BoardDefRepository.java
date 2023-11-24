package com.example.sinzi_CodingTest.post.repository;

import com.example.sinzi_CodingTest.post.entity.BoardDef;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BoardDefRepository extends JpaRepository<BoardDef,Long> {

}
