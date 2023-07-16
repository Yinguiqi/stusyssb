package com.mht.stueaxm.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mht.stueaxm.domain.Student;
import com.mht.stueaxm.domain.User;

import java.util.List;

/**
 * @author Kirtico
 * @date 2022/9/9&10:00
 */
public interface LoginService extends IService<User>{

    //getUserByNameAndPass
    User login(String username, String password);


}
