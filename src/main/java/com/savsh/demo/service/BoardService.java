package com.savsh.demo.service;

import com.savsh.demo.dao.BoardDao;
import com.savsh.demo.entity.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardService {

    @Autowired
    private BoardDao boardDao;

    public Board findOne(int i) {
        return boardDao.findOne(i);
    }
}
