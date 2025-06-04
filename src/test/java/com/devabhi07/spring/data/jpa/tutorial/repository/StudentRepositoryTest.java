package com.devabhi07.spring.data.jpa.tutorial.repository;

import com.devabhi07.spring.data.jpa.tutorial.entity.Guardian;
import com.devabhi07.spring.data.jpa.tutorial.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest

//@DataJpaTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent(){
        Student student = Student.builder()
                .emailId("test@gmail.com")
                .firstName("will")
                .lastName("Jaks")
                //.guardianName("Ronaldo")
                //.guardianEmail("ronaldo@gmail.com")
                //.guardianMobile("9999999999")
                .build();
        studentRepository.save(student);
    }
    @Test
    public void saveStudentWithGuardian(){
        Guardian guardian = Guardian.builder()
                .email("ronaldo@gmail.com")
                .name("Ronaldo")
                .mobile("9999999999")
                .build();

        Student student = Student.builder()
                .emailId("test3@gmail.com")
                .firstName("test3")
                .lastName("lasttest3")
                .guardian(guardian)
                .build();

        studentRepository.save(student);

    }

    @Test
    public void printAllStudent(){
        List<Student> studentList= studentRepository.findAll();
        System.out.println("studentList ="+ studentList);
    }

}