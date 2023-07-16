package com.mht.stueaxm.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
public class LoginServiceImpl extends ServiceImpl<LoginMapper,User> implements LoginService {
    // 自动注入
    @Autowired
    private LoginMapper userDao;

    @Override
    public User login(String username,String password)  {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        // 直接调用BaseMapper的方法
        return userDao.selectOne(wrapper.eq("username", username).eq("password", password));

    }

}
