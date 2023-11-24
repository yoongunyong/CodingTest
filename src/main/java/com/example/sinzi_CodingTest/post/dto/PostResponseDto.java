package com.example.sinzi_CodingTest.post.dto;

import lombok.Setter;

import java.time.LocalDateTime;

@Setter
public class PostResponseDto {

    private long postId;
    private String postDef;
    private String postTitle;
    private String postCn;
    private String userId;
    private LocalDateTime createAt;
}
