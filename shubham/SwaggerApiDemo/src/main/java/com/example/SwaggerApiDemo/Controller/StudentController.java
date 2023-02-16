package com.example.SwaggerApiDemo.Controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.SwaggerApiDemo.Entity.StudentDao;
import com.example.SwaggerApiDemo.Service.StudentService;

@RestController
@RequestMapping("/api/v1/student/")
public class StudentController {
    @Autowired
    private StudentService studentService;
    @GetMapping("")
    public List<StudentDao> getAllStudent()
    {
        return  studentService.getStudentDaoList();
    }

    //Get the Student details
    @GetMapping("/{id}")
    public  StudentDao getStudentDetailsById(@PathVariable int id)
    {
        return studentService.getUserDetails(id);
    }

    //Add new Student
    @PostMapping("")
    public StudentDao addStudent(@RequestBody StudentDao studentDao)
    {
        return studentService.addUser(studentDao);
    }

    //Delete user by id
    @DeleteMapping("/{id}")
    public StudentDao deleteStudentById(@PathVariable int id)
    {
        return  studentService.deleteUserByID(id);
    }
}
