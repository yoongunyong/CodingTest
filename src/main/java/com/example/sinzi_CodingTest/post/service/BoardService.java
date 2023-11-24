package com.example.sinzi_CodingTest.post.service;

import com.example.sinzi_CodingTest.post.dto.UpdateDto;
import com.example.sinzi_CodingTest.post.entity.BoardDef;
import com.example.sinzi_CodingTest.post.entity.PostEntity;
import com.example.sinzi_CodingTest.post.repository.BoardDefRepository;
import com.example.sinzi_CodingTest.post.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BoardService {
    @Autowired
    private BoardDefRepository boardRepository;
    @Autowired
    private PostRepository postRepository;

    //생성하기
    public void post(PostEntity post) throws Exception {
        postRepository.save(post);
    }
    //읽기
    public PostEntity read(long postId){
        Optional<PostEntity> findPost = postRepository.findById(postId);
        if(findPost.isPresent()){
            return findPost.get();
        }
        throw new RuntimeException("해당 게시글을 찾을 수 없습니다.");
    }

    //수정하기
    public Optional<PostEntity> update(long postId, UpdateDto updateDto){
        Optional<PostEntity> findPost = postRepository.findById(postId);
        findPost.ifPresent(t->{
            if(updateDto.getTitle()!=null){
                t.setPostTitle(updateDto.getTitle());
            }
            if(updateDto.getContent()!=null){
                t.setPostContent(updateDto.getContent());
            }
            postRepository.save(t);
        });
        return findPost;
    }

    //삭제하기
    public void delete(long postId){
        postRepository.deleteById(postId);
    }

    public BoardDef verifyBoardDef(long boardDefId) throws Exception {
        Optional<BoardDef> findBoardDef = boardRepository.findById(boardDefId);
        return findBoardDef.orElseThrow(()->new Exception());
    }


}
