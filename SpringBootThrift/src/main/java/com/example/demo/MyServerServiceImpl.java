package com.example.demo;

import org.springframework.stereotype.Service;

@Service
public class MyServerServiceImpl implements StudentService.Iface {

    @Override
    public Student getStudentByName(String name) throws DataException, org.apache.thrift.TException {
        System.out.println(name);
        Student student = new Student();
        student.setName(name);
        student.setAge(20);
        student.setAddress("shenzhen");
        try {
            Thread.sleep(5000);
        }catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        return student;
    }

    @Override
    public void save(Student student) throws DataException, org.apache.thrift.TException {
        try {
            Thread.sleep(5000);
        }catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        System.out.println("保存成功");
    }
}
