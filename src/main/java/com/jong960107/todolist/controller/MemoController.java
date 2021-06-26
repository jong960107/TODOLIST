package com.jong960107.todolist.controller;


import com.jong960107.todolist.domain.Memo;
import com.jong960107.todolist.domain.MemoRepository;
import com.jong960107.todolist.domain.MemoRequestDto;
import com.jong960107.todolist.service.MemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
@RestController
public class MemoController {

    private final MemoRepository memoRepository;
    private final MemoService memoService;


    //CRUD중 CREATE에 해당합니다..!
    @PostMapping("/api/memos")
    public Memo createMemo(@RequestBody MemoRequestDto requestDto){

        Memo memo = new Memo(requestDto);
        return memoRepository.save(memo);
    }

    //CRUD중 READ에 해당합니다..!
    @GetMapping("/api/memos")
    public List<Memo> getMemos(){

        return memoRepository.findAllByOrderByModifiedAtDesc();

    }




    //CRUD중 DELETE에 해당합니다..!

    @DeleteMapping("/api/memos/{id}")
    public Long deleteMemo(@PathVariable Long id){

        memoRepository.deleteById(id);
        return id;

    }

}
