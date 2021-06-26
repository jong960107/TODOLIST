package com.jong960107.todolist.service;


import com.jong960107.todolist.domain.Memo;
import com.jong960107.todolist.domain.MemoRepository;
import com.jong960107.todolist.domain.MemoRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@RequiredArgsConstructor
@Service
public class MemoService {

    private final MemoRepository memoRepository;

    @Transactional
    public Long update(Long id, MemoRequestDto memoRequestDto){

        Memo memo = memoRepository.findById(id).orElseThrow(

                () ->new IllegalArgumentException("아이디가 존재 안함")

        );

        memo.update(memoRequestDto);
        return memo.getId();


    }

}
