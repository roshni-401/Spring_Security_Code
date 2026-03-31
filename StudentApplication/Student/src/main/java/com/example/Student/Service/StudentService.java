package com.example.Student.Service;

import com.example.Student.Entity.Student;
import com.example.Student.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private static StudentRepository repository;


    @Transactional(propagation = Propagation.MANDATORY)
    public  Student addStudent(Student student) {
        System.out.println("Transaction");
        return repository.save(student);
    }

    public Optional<Student> getStudentById(Integer id) {

        return repository.findById(id);
    }
}
