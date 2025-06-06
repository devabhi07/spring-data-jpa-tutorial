package com.devabhi07.spring.data.jpa.tutorial.repository;

import com.devabhi07.spring.data.jpa.tutorial.entity.Course;
import com.devabhi07.spring.data.jpa.tutorial.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void saveTeacher() {

        Course courseMath = Course.builder()
                .title("Math")
                .credit(5)
                .build();
        Course courseDS = Course.builder()
                .title("DS")
                .credit(4)
                .build();


        Teacher teacher =
                Teacher.builder()
                        .firstName("Ujjal")
                        .lastName("Deb")
                        //.course(List.of(courseMath,courseDS))
                        .build();
teacherRepository.save(teacher);

    }
}