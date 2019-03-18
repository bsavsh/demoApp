package com.savsh.demo.controller;

import com.savsh.demo.entity.Task;
import com.savsh.demo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("/task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/{id}")
    public Task getById(@PathVariable int id) {
        return taskService.findOne(id);
    }
}
