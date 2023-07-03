package com.mht.stueaxm.mapper;

import com.mht.stueaxm.domain.Student;
import com.mht.stueaxm.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Kirtico
 * @date 2022/9/9&9:03
 */
@Repository
@Mapper
public interface LoginMapper {
    /**
     * 登录方法
     * 查询数据库的用户名和密码 返回值为一个对象，如果对象不存在则返回空
     * 此处可能会引发空指针异常，可以直接抛出
     * @param username
     * @param password
     * @return
     */
    User selectUser(@Param("username") String username, @Param("password") String password);

}
