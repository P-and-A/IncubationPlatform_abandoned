package com.incubationplatform.mapper;

import com.incubationplatform.entity.TestEntity;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by GMUK on 2018/10/17 0017.
 */
public interface TestMapper {
    @Select("select * from products")
    public List<TestEntity> getAlldata();
}
