package com.savsh.demo.controller;

import com.savsh.demo.entity.Board;
import com.savsh.demo.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("/board")
public class BoardController {

    @Autowired
    private BoardService boardService;

    @GetMapping("/{id}")
    public Board getById(@PathVariable int id) {
        return boardService.findOne(id);
    }

}
