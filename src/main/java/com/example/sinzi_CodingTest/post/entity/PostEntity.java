package com.example.sinzi_CodingTest.post.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@Entity(name = "POST")
@Table(name = "POST")
public class PostEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "POST_NO")
    private long postId;

    @OneToOne
    @JoinColumn(name = "boardDefId")
    private BoardDef boardDef;

    @Column(name = "POST_SJ")
    private String postTitle;

    @Column(name = "POST_CN")
    private String postContent;

    @Column(name = "REGSTR_ID")
    private String regstrId;

    @OneToMany(mappedBy = "post")
    private List<PostTagEntity> postTagEntityList = new ArrayList<>();

    @Column(name = "REG_DT")
    private LocalDateTime regDt = LocalDateTime.now();

    public void addPostTag(PostTagEntity tag){
        postTagEntityList.add(tag);
    }
}
