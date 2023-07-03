package com.mht.stueaxm.service.impl;

import com.mht.stueaxm.domain.Student;
import com.mht.stueaxm.mapper.LoginMapper;
import com.mht.stueaxm.mapper.StudentInfoMapper;
import com.mht.stueaxm.service.StudentInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Kirtico
 * @date 2023/7/3&20:48
 */
@Service
public class StudentInfoServiceImpl implements StudentInfoService {
    @Autowired
    private StudentInfoMapper studentDao;
    @Override
    public int getTotal() {
        return studentDao.getTotal();
    }

    @Override
    public void addStudent(Student student) {
        studentDao.addStudent(student);
    }

    @Override
    public void deleteStudent(int id) {
        studentDao.deleteStudent(id);
    }

    @Override
    public void updateStudent(Student student) {
        studentDao.updateStudent(student);
    }

    @Override
    public List<Student> retrieveStudent(Student student) {
        return  studentDao.retrieveStudent(student);
    }

    @Override
    public Student getStudent(int id) {
        return studentDao.getStudent(id);
    }

    @Override
    public List<Student> list(int start, int count) {
        return studentDao.list(start, count);
    }
}
