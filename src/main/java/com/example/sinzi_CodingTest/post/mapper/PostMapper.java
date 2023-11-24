package com.example.sinzi_CodingTest.post.mapper;

import com.example.sinzi_CodingTest.post.dto.PostDto;
import com.example.sinzi_CodingTest.post.dto.PostResponseDto;
import com.example.sinzi_CodingTest.post.entity.BoardDef;
import com.example.sinzi_CodingTest.post.entity.PostEntity;
import com.example.sinzi_CodingTest.post.entity.PostTagEntity;

public interface PostMapper {
    PostEntity postDtoToPostEntity(PostDto postDto, BoardDef boardDef, PostTagEntity pt);
    PostResponseDto postEntityToPostResponseDto(PostEntity post);
}
