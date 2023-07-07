package com.mht.stueaxm.service;

import com.mht.stueaxm.domain.Role;
import com.mht.stueaxm.domain.User;

import java.util.List;

/**
 * @author Kirtico
 * @date 2023/7/6&13:57
 */
public interface UserInfoService {

    User getUserByName(String userName);

    int getRoleByUserId(int user_id);

    int getPermissionByRoleId(int role_id);
}
