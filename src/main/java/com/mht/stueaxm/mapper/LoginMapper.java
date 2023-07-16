package com.mht.stueaxm.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
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
@Mapper
public interface LoginMapper extends BaseMapper<User>{

}
