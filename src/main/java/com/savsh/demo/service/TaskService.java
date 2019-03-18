package com.savsh.demo.service;

import com.savsh.demo.dao.TaskDao;
import com.savsh.demo.entity.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

    @Autowired
    private TaskDao taskDao;

    public Task findOne(int i) {
        return taskDao.findOne(i);
    }

}
