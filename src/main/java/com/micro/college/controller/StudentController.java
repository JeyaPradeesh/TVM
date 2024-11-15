package com.micro.college.controller;

import com.micro.college.model.Student;
import com.micro.college.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/college")
public class StudentController {
 ///for microservice
    @Autowired
    private StudentService studentService;

    @GetMapping("/view")
    public List<Student> view() {
        return studentService.viewEmployee();
    }

    @PostMapping("/add")
    public Student add(@RequestBody Student student) {
        return studentService.addEmployee(student);
    }

    @GetMapping("/viewById/{id}")
    public Optional<Student> viewById(@PathVariable Long id) {
        return studentService.viewById(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Student> updateEmployee(@PathVariable Long id, @RequestBody Student student) {
        student.setId(id);
        Student updatedEmployee = studentService.updateEmployee(id, student);
        return ResponseEntity.ok(updatedEmployee);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        studentService.delete(id);
        return "Deleted";
    }
}

