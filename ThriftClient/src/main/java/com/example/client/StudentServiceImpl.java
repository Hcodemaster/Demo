package com.example.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl {
    @Autowired
    ThriftClient thriftClient;

    public Student getStudentByName(String name)
    {
        try{
            thriftClient.open();
            Student student = thriftClient.getService().getStudentByName(name);
            System.out.println("成功获取的学生信息为：" + student);
            return student;
        }catch (Exception e)
        {
            e.printStackTrace();
        }finally {
            thriftClient.close();
        }
        return null;
    }

    public void save(Student student)
    {
        try
        {
            thriftClient.open();
            thriftClient.getService().save(student);
        }catch (Exception e)
        {
            e.printStackTrace();
        }finally {
            thriftClient.close();
        }
    }
}
