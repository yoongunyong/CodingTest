package com.example.sinzi_CodingTest.post.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Getter
@Setter
@NoArgsConstructor
@Entity(name = "TAG")
@Table(name = "TAG")
public class TagEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TAG_NO")
    private long tagId;

    private String tag;

    @OneToOne
    @JoinColumn(name = "boardDefId")
    private BoardDef boardDef;


}
