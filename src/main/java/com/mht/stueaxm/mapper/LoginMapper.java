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
    /**
     * 获取学生总数
     * @return
     */
    int getTotal();

    /**
     * 添加一个学生
     * @param student
     */
    void addStudent(Student student);

    /**
     * 查询学生
     * @param student
     */
    List<Student> retrieveStudent(Student student);

    /**
     * 根据 id 删除一个人学生
     * @param id
     */
    void deleteStudent(int id);

    /**
     * 修改一个学生信息
     * @param student
     */
    void updateStudent(Student student);

    /**
     * 根据 id 获取一个学生信息
     * @param id
     * @return
     */
    Student getStudent(int id);

    /**
     * 查询从start位置开始的count条数据
     */
    List<Student> list(int start, int count);
}
