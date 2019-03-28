package integration.com.savsh.demo.service;

import com.savsh.demo.Application;
import com.savsh.demo.entities.Student;
import com.savsh.demo.service.StudentService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;

import javax.persistence.EntityManager;
import java.util.List;


import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;

@RunWith(JUnitPlatform.class)
@ContextConfiguration(classes = Application.class)
@AutoConfigureTestDatabase(replace = NONE)
@DataJpaTest(includeFilters = @ComponentScan.Filter(Service.class))
@ActiveProfiles(profiles = {"test", "dev"})
@Tag("integration")
class StudentServiceImplIT {

    private static final Logger LOGGER = LoggerFactory.getLogger(StudentServiceImplIT.class);
    private static final int ONE = 1;

    @Autowired
    private StudentService studentService;

    @Autowired
    private EntityManager entityManager;

    @Test
    void addStudent() {
        Student student = getStudent();
        Student resultStudent = studentService.addStudent(student);

        assertThat(resultStudent).hasFieldOrPropertyWithValue("firstName", "Bohdan");
        assertThat(resultStudent).hasFieldOrPropertyWithValue("lastName", "Savshak");
        assertThat(resultStudent).hasFieldOrPropertyWithValue("email", "savshak@gmail.com");
    }

    @Test
    void getById() {
        Student student = new Student();
        student.setLastName("testName");
        entityManager.persist(student);
        List<Student> all = studentService.findAll();
        assertThat(all.contains(student));
        LOGGER.info("Size: {}", all.size());
    }

    @Test
    void findAll() {
        Student student = getStudent();
        studentService.addStudent(student);

        List<Student> all = studentService.findAll();
        assertThat(all.size() == ONE);
    }

    @Test
    void udpateStudent() {
        Student student = getStudent();
        studentService.addStudent(student);

        student.setLastName("TestName");
        Student updatedStudent = studentService.updateStudent(student);

        assertThat(updatedStudent.equals(student));
    }

    private Student getStudent() {
        Student student = new Student();
        student.setFirstName("Bohdan");
        student.setLastName("Savshak");
        student.setEmail("savshak@gmail.com");
        return student;
    }
}