package com.example.Student.Controller;

import com.example.Student.Entity.Student;
import com.example.Student.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/addStudent")
    public ResponseEntity<Student> addStudent(@RequestBody Student student){
        Student saveStudent = studentService.addStudent(student);
        return ResponseEntity.ok(student);
    }

    @GetMapping("/getStudentById/{id}")
    public ResponseEntity<Optional<Student>> getStudentById(@PathVariable("id") Integer id){
        Optional<Student> studentById = studentService.getStudentById(id);
        return ResponseEntity.ok(studentById);
    }
}
