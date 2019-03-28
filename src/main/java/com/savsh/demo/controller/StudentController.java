package com.savsh.demo.controller;

import com.savsh.demo.entities.Student;
import com.savsh.demo.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class StudentController {

    private static final Logger LOGGER = LoggerFactory.getLogger(StudentController.class);

    @Autowired
    private StudentService studentService;

    @GetMapping("/hell")
    public String hell() {
        return "Hell yea";
    }

    @GetMapping("/student")
    public List<Student> getAll() {
        return studentService.findAll();
    }

    @PostMapping("/student")
    public void addStudent(@RequestBody Student student) {
        studentService.addStudent(student);
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity noSuchElementHandler(NoSuchElementException ex) {
        LOGGER.info("Exception catched, message: {}", ex.getMessage());
        return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
    }
}
