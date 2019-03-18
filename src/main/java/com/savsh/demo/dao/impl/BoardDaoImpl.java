package com.savsh.demo.dao.impl;

import com.savsh.demo.dao.AbstractJpaDao;
import com.savsh.demo.dao.BoardDao;
import com.savsh.demo.entity.Board;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDaoImpl extends AbstractJpaDao<Board> implements BoardDao {
    public BoardDaoImpl() {
        super(Board.class);
    }
}
