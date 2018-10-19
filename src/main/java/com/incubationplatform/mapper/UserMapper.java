package com.incubationplatform.mapper;

import com.incubationplatform.entity.User;
import org.apache.ibatis.annotations.Select;

/**
 * Created by GMUK on 2018/10/18 0018.
 */
public interface UserMapper {
    @Select("select * from user where userName=#{loginName}")
    User findUserByUserName(String loginName);
}
