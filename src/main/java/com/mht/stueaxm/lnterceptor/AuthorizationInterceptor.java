package com.mht.stueaxm.lnterceptor;

import com.mht.stueaxm.domain.Permission;
import com.mht.stueaxm.domain.Role;
import com.mht.stueaxm.domain.User;
import com.mht.stueaxm.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Kirtico
 * @date 2023/7/6&16:14
 */
public class AuthorizationInterceptor implements HandlerInterceptor {

    @Autowired
    private UserInfoService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 获取登录用户的信息和权限

        String userName = (String) request.getSession().getAttribute("userName");
        System.out.println("userName: " + userName);
        User user = userService.getUserByName(userName);
        int user_id = user.getId();
        int role_id = userService.getRoleByUserId(user_id);
        int permission_id = userService.getPermissionByRoleId(role_id);

        // 判断用户权限是否允许访问页面
        if (permission_id == 1) {
            response.sendRedirect("/student");
            return false;
        }
        return true;
    }
}
