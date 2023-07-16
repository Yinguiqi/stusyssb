package com.mht.stueaxm.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mht.stueaxm.domain.Student;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Kirtico
 * @date 2023/7/3&20:56
 */
@Repository
@Mapper
public interface StudentInfoMapper extends BaseMapper<Student> {
    /**
     * 获取学生总数
     * @return
     */
//    int getTotal();

    /**
     * 添加一个学生
     * @param student
     */
//    void addStudent(Student student);

    /**
     * 查询学生
     * @param student
     */
//    List<Student> retrieveStudent(Student student);


    /**
     * 根据 id 删除一个人学生
     * @param id
     */
//    void deleteStudent(int id);

    /**
     * 修改一个学生信息
     * @param student
     */
//    void updateStudent(Student student);

    /**
     * 根据 id 获取一个学生信息
     * @param id
     * @return
     */
//    Student getStudent(int id);

    /**
     * 查询从start位置开始的count条数据
     */
    List<Student> list(int start, int count);
}
