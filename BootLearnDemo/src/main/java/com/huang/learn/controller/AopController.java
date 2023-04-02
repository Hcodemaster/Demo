package com.huang.learn.controller;


import com.huang.learn.BO.StudentBo;
import com.huang.learn.DTO.StudentDto;
import com.huang.learn.mapstruct.StudentMapper;
import org.example.Score;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AopController {



    @Autowired
    StudentMapper mapper;



    @RequestMapping("/mapstruct")
    public String testMapStrut(){
        StudentBo student = new StudentBo(1,"huang", 25, Boolean.TRUE, "math", new Score());
        student = null;
        StudentDto studentDto = mapper.convertToBo(student);
//        System.out.println(studentDto.getStudentId());
//        System.out.println(studentDto.getStudentName());
        System.out.println(studentDto == null);
        return "success";
    }

}
