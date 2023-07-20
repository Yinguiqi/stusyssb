package com.mht.stueaxm.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mht.stueaxm.domain.Student;
import com.mht.stueaxm.domain.User;
import com.mht.stueaxm.mapper.LoginMapper;
import com.mht.stueaxm.mapper.StudentInfoMapper;
import com.mht.stueaxm.mapper.UserInfoMapper;
import com.mht.stueaxm.service.StudentInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * @author Kirtico
 * @date 2023/7/3&20:48
 */
@Service
public class StudentInfoServiceImpl extends ServiceImpl<StudentInfoMapper,Student> implements StudentInfoService {
    @Autowired
    private StudentInfoMapper studentDao;

    @Override
    public int getTotal() {
        return studentDao.selectCount(null);
    }

    @Override
    public void addStudent(Student student) {studentDao.insert(student);}

    @Override
    public void deleteStudent(int id) {
        studentDao.deleteById(id);
    }

    @Override
    public void updateStudent(Student student) {studentDao.updateById(student);}
//    @Override
//    public void  updateLeftDorm(int id){
//        studentDao.
//    };

    @Override
    public List<Student> retrieveStudent(int studentId, int dormitoryId, String name) {
        QueryWrapper<Student> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(studentId != -1,"student_id", studentId)
                .eq(dormitoryId != -1,"dormitory_id", dormitoryId)
                .like(StringUtils.hasLength(name),"name",name);
        return  studentDao.selectList(queryWrapper);
    }

    @Override
    public Student getStudent(int id) {
        return studentDao.selectById(id);
    }
    @Override
    public List<Student> list(int start, int count) {return studentDao.list(start, count);}
}
