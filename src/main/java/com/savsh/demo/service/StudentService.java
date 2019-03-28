package com.savsh.demo.service;

import com.savsh.demo.entities.Student;

import java.util.List;

public interface StudentService {

    Student findById(Long id);

    Student addStudent(Student student);

    List<Student> findAll();

    Student updateStudent(Student student);
}
