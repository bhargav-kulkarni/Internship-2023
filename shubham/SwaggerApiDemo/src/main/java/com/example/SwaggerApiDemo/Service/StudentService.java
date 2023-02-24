package com.example.SwaggerApiDemo.Service;

import java.util.*;

import org.springframework.stereotype.Service;

import com.example.SwaggerApiDemo.Entity.StudentDao;

@Service
public class StudentService {
    List<StudentDao> studentDaoList;
    public  StudentService()
    {
        studentDaoList=new ArrayList<>();
        studentDaoList.add(new StudentDao(1,"Shubham",32242324,"At post nimsod"));
        studentDaoList.add(new StudentDao(2,"Shubham",32242324,"At post nimsod"));

    }
    // retrerive all user
    public List<StudentDao> getStudentDaoList()
    {
        return  studentDaoList;
    }

    //reterive Specfic user
    public  StudentDao getUserDetails(int id)
    {
        for(StudentDao d:studentDaoList)
        {
            if(d.getId()==id)
            {
                return d;
            }
        }
        return  null;
    }

    //Add new user

    public StudentDao addUser(StudentDao studentDao)
    {
        studentDaoList.add(studentDao);
        return  studentDao;
    }

    public  StudentDao deleteUserByID(int id)
    {
        for(StudentDao d:studentDaoList)
        {
            if(d.getId()==id)
            {
                studentDaoList.remove(d);
                return  d;
            }
        }
        return  null;

    }
    //remove Student Object

    public StudentDao removeStudentByStudentDetails(StudentDao studentDao)
    {
        studentDaoList.remove(studentDao);
        return  studentDao;
    }
}
