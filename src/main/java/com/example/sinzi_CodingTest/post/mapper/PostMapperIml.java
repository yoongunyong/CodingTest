package com.example.sinzi_CodingTest.post.mapper;

import com.example.sinzi_CodingTest.post.dto.PostDto;
import com.example.sinzi_CodingTest.post.dto.PostResponseDto;
import com.example.sinzi_CodingTest.post.entity.BoardDef;
import com.example.sinzi_CodingTest.post.entity.PostEntity;
import com.example.sinzi_CodingTest.post.entity.PostTagEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PostMapperIml implements PostMapper{
    @Override
    public PostEntity postDtoToPostEntity(PostDto postDto, BoardDef boardDef, PostTagEntity pt) {
        PostEntity post = new PostEntity();
        post.setPostTitle(postDto.getTitle());
        post.setPostContent(postDto.getContent());
        post.setRegstrId("test");
        post.setBoardDef(boardDef);
        post.addPostTag(pt);
        return post;
    }

    @Override
    public PostResponseDto postEntityToPostResponseDto(PostEntity post) {
        PostResponseDto response = new PostResponseDto();
        response.setPostId(post.getPostId());
        response.setPostTitle(post.getPostTitle());
        response.setPostCn(post.getPostContent());
        response.setPostDef(post.getBoardDef().getBoardDefId());
        response.setCreateAt(post.getRegDt());
        response.setUserId(post.getRegstrId());

        return response;
    }


}
