package com.jong960107.todolist.domain;


import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
public class Memo extends Timestamped{

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column(nullable = false)
    private String contents;

    public Memo(String contents){

        this.contents = contents;

    }

    public Memo(MemoRequestDto requestDto){

        this.contents = requestDto.getContents();

    }


    public void update(MemoRequestDto memoRequestDto) {

        this.contents = memoRequestDto.getContents();

    }
}
