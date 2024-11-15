package com.micro.college.service;

import com.micro.college.model.Student;
import com.micro.college.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepo studentRepo;

    public List<Student> viewEmployee() {
        return studentRepo.findAll();
    }

    public Student addEmployee(Student student) {
        return studentRepo.save(student);
    }

    public Optional<Student> viewById(Long id) {
        return studentRepo.findById(id);
    }

    public Student updateEmployee(Long id, Student student) {
        Optional<Student> existingEmployee = studentRepo.findById(id);
        if (existingEmployee.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee not found");
        }
        student.setId(id);
        return studentRepo.save(student);
    }

    public void delete(Long id) {
        studentRepo.deleteById(id);
    }
}
