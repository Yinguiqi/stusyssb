package com.mht.stueaxm.service.impl;

import com.mht.stueaxm.domain.User;
import com.mht.stueaxm.mapper.UserInfoMapper;
import com.mht.stueaxm.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Kirtico
 * @date 2023/7/6&13:58
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Autowired
    private UserInfoMapper userDao;

    @Override
    public User getUserByName(String userName) {
        return  userDao.getUserByName(userName);
    }
}
