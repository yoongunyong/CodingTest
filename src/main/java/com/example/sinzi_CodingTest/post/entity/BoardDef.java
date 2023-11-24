package com.example.sinzi_CodingTest.post.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Setter
@Getter
@NoArgsConstructor
@Entity(name = "BOARD_DEF")
@Table(name = "BOARD_DEF")
public class BoardDef {

    @Id
    @Column(name = "BOARD_CD")
    private String boardDefId;

    @Column(name = "BOARD_NM", nullable = false)
    private String boardName;

    @OneToMany(mappedBy = "boardDef")
    List<PostEntity> postEntities = new ArrayList<>();

}
