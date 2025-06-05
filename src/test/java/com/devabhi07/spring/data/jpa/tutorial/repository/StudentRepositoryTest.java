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

//    @Test
//    public void printByFirstName(){
//        List<Student> student=studentRepository.findByFirstName("will");
//        System.out.println("Student First Name"+ student);
//    }
//    @Test
//    public void printByFirstNameContaining(){
//        List<Student> students=studentRepository.findByFirstNameContaining("will");
//        System.out.println("Student First Name"+ students);
//    }
    @Test
    public void printgetStudentByEmailAddress(){
        Student student=studentRepository.getStudentByEmailAddress("will@gmail.com");
        System.out.println("Email ="+ student);
    }
    @Test
    public void printgetStudentByEmailAddresss1(){
        String student = studentRepository.getStudentFirstNameByEmailAddress("will@gmail.com");
        System.out.println("Name ="+ student );
    }

    @Test
    public void printgetStudentByEmailAddressNative(){
        Student student = studentRepository.getStudentByEmailAddressNative("will@gmail.com");
        System.out.println("Name ="+student);
    }

    @Test
    public void printgetStudentByEmailAddressNativeNamParam(){
        Student student = studentRepository.getStudentByEmailAddressNativeNameParam("will@gmail.com");
        System.out.println("Student = "+student);
    }

    @Test
    public void updateStudentNameByEmailId(){
         studentRepository.updateStudentNameByEmailId("ujjaldeb","will@gmail.com");
        System.out.println("Student = "+studentRepository.getStudentByEmailAddress("will@gmail.com"));
    }
//    @Test
//    public void updateStudentNameByEmailId1(){
//        studentRepository.updateStudentNameByEmailId("ujjaldeb","will@gmail.com");
//        System.out.println("Student = "+studentRepository.getStudentByEmailAddress("will@gmail.com"));
//    }

}