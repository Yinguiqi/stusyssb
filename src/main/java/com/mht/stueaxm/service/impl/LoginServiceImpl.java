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

}
