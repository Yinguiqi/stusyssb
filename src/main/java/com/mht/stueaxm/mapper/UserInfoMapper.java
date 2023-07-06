package com.mht.stueaxm.mapper;


import com.mht.stueaxm.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


/**
 * @author Kirtico
 * @date 2023/7/6&14:03
 */
@Repository
@Mapper
public interface UserInfoMapper {
    User getUserByName(String userName);
}
