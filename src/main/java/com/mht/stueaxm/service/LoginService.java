package com.mht.stueaxm.service;

import com.mht.stueaxm.domain.Student;
import com.mht.stueaxm.domain.User;

import java.util.List;

/**
 * @author Kirtico
 * @date 2022/9/9&10:00
 */
public interface LoginService {

    //getUserByNameAndPass
    User login(String username, String password);
    int getTotal();
    void   addStudent(Student student);

    List<Student>   retrieveStudent(Student student);
    void   deleteStudent(int id);
    void   updateStudent(Student student);
    Student getStudent(int id);
    List<Student> list(int start, int count);


}
