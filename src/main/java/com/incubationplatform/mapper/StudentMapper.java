package com.incubationplatform.mapper;

import com.incubationplatform.entity.Student;
import org.apache.ibatis.annotations.Select;

/**
 * @author liaochaofan
 * @date 2018/11/25 14:24
 */
public interface StudentMapper {
    @Select("select * from student where id=#{id}")
    public Student selectById(String id);
}
