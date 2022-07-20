package com.example.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("thrift")
public class StudentController {
    @Autowired
    StudentServiceImpl studentService;

    @GetMapping("get")
    public Student getStudentByName(String name)
    {
        return studentService.getStudentByName(name);
    }

    @GetMapping("save")
    public Student save()
    {
        Student student = new Student();
        student.setAddress("shenzhen");
        student.setAge(20);
        student.setName("huang");
        studentService.save(student);
        return student;
    }
}
