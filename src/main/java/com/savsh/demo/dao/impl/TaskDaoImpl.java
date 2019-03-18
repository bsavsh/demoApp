package com.savsh.demo.dao.impl;

import com.savsh.demo.dao.AbstractJpaDao;
import com.savsh.demo.dao.TaskDao;
import com.savsh.demo.entity.Task;
import org.springframework.stereotype.Repository;

@Repository
public class TaskDaoImpl extends AbstractJpaDao<Task> implements TaskDao {
    public TaskDaoImpl() {
        super(Task.class);
    }
}
