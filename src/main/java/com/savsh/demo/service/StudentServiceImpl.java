package com.savsh.demo.service;

import com.savsh.demo.dao.StudentDao;
import com.savsh.demo.entities.Student;
import com.savsh.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao studentDao;

    @Override
    public Student findById(Long id) {
        return studentDao.findById(id).orElseThrow();
    }

    @Override
    public Student addStudent(Student student) {
        return studentDao.save(student);
    }

    @Override
    public List<Student> findAll() {
        return studentDao.findAll();
    }

    @Override
    public Student updateStudent(Student student) {
        return studentDao.save(student);
    }
}
