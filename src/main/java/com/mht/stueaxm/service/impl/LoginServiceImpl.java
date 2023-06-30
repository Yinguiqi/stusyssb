package com.mht.stueaxm.service.impl;

import com.mht.stueaxm.domain.Student;
import com.mht.stueaxm.domain.User;
import com.mht.stueaxm.mapper.LoginMapper;
import com.mht.stueaxm.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @author Kirtico
 * @date 2022/9/9&10:28
 */
@Service
public class LoginServiceImpl implements LoginService {

    // 自动注入
    @Autowired
    private LoginMapper userDao;

    @Override
    public  User login(String username,String password)  {
        return userDao.selectUser(username,password);
    }
    @Override
    public int getTotal() {
        return userDao.getTotal();
    }

    @Override
    public void addStudent(Student student) {
        userDao.addStudent(student);
    }

    @Override
    public void deleteStudent(int id) {
        userDao.deleteStudent(id);
    }

    @Override
    public void updateStudent(Student student) {
        userDao.updateStudent(student);
    }

    @Override
    public List<Student>retrieveStudent(Student student) {
      return  userDao.retrieveStudent(student);
    }

    @Override
    public Student getStudent(int id) {
        return userDao.getStudent(id);
    }

    @Override
    public List<Student> list(int start, int count) {
        return userDao.list(start, count);
    }
}
