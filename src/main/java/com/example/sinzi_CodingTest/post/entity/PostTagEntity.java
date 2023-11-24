package com.example.sinzi_CodingTest.post.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "POST_TAG")
@Table(name = "POST_TAG")
public class PostTagEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="BOARD_TAG_NO")
    private long postTagId;

    @ManyToOne
    @JoinColumn(name = "POST_NO")
    private PostEntity post;

    @ManyToOne
    @JoinColumn(name = "TAG_ID")
    private TagEntity tag;

    @OneToOne
    @JoinColumn(name = "BOARD_CD")
    private BoardDef boardDef;



}
