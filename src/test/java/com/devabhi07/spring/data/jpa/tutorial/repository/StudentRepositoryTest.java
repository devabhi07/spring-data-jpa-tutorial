package com.devabhi07.spring.data.jpa.tutorial.repository;

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
                .emailId("will@gmail.com")
                .firstName("will")
                .lastName("Jaks")
                .guardianName("Ronaldo")
                .guardianEmail("ronaldo@gmail.com")
                .guardianMobile("9999999999")
                .build();

        studentRepository.save(student);
    }

    @Test
    public void printAllStudent(){
        List<Student> studentList= studentRepository.findAll();
        System.out.println("studentList ="+ studentList);
    }

}