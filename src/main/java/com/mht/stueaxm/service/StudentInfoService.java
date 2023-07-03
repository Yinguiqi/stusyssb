package com.mht.stueaxm.service;

import com.mht.stueaxm.domain.Student;

import java.util.List;

/**
 * @author Kirtico
 * @date 2023/7/3&20:25
 */
public interface StudentInfoService {

    void   addStudent(Student student);

    void   deleteStudent(int id);

    void   updateStudent(Student student);
    List<Student> list(int start, int count);
    int getTotal();
    Student getStudent(int id);
    List<Student>   retrieveStudent(Student student);
}
