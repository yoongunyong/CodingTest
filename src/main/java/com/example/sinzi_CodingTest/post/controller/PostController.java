package com.example.sinzi_CodingTest.post.controller;

import com.example.sinzi_CodingTest.post.dto.PostDto;
import com.example.sinzi_CodingTest.post.dto.PostResponseDto;
import com.example.sinzi_CodingTest.post.dto.UpdateDto;
import com.example.sinzi_CodingTest.post.entity.BoardDef;
import com.example.sinzi_CodingTest.post.entity.PostEntity;
import com.example.sinzi_CodingTest.post.entity.PostTagEntity;
import com.example.sinzi_CodingTest.post.mapper.PostMapperIml;
import com.example.sinzi_CodingTest.post.repository.BoardDefRepository;
import com.example.sinzi_CodingTest.post.repository.PostTagRepository;
import com.example.sinzi_CodingTest.post.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PostController {
    @Autowired
    private BoardDefRepository boardRepository;
    @Autowired
    private PostTagRepository postTagRepository;
    @Autowired
    private PostMapperIml postMapperIml;
    @Autowired
    private BoardService  boardService;

    //게시글 생성하기
    @PostMapping("/{boardDef}/{tag-id}")
    public ResponseEntity post(@RequestBody PostDto postDto, @PathVariable("boardDef")long boardDefId,
                               @PathVariable("tag-id")long tag) throws Exception {
        BoardDef boardDef = boardService.verifyBoardDef(boardDefId);
        PostTagEntity findpt = postTagRepository.findById(tag).get();
        PostEntity post = postMapperIml.postDtoToPostEntity(postDto,boardDef,findpt);
        boardService.post(post);
        return new ResponseEntity(HttpStatus.OK);
    }

    //게시글 읽어오기
    @GetMapping("/{post-id}")
    public ResponseEntity read(@PathVariable("post-id")long postId){
        PostEntity findPost = boardService.read(postId);
        PostResponseDto response = postMapperIml.postEntityToPostResponseDto(findPost);
        return new ResponseEntity(response,HttpStatus.OK);
    }

    //게시글 수정하기
    @PatchMapping("/{post-id}")
    public ResponseEntity update(@PathVariable("post-id")long postId, @RequestBody UpdateDto updateDto){
        PostEntity savedPost = boardService.update(postId,updateDto).get();
        PostResponseDto responseDto = postMapperIml.postEntityToPostResponseDto(savedPost);
        return new ResponseEntity(responseDto,HttpStatus.OK);
    }

    //게시글 삭제하기
    @DeleteMapping("/{post-id}")
    public ResponseEntity delete(@PathVariable("post-id")long postId){
        boardService.delete(postId);
        return new ResponseEntity<>("게시물이 삭제되었습니다.",HttpStatus.OK);

    }
}
