package com.incubationplatform.dao;

import com.incubationplatform.entity.TestEntity;
import com.incubationplatform.mapper.TestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by GMUK on 2018/10/17 0017.
 */
@Repository
public class TestDao {

    @Autowired
    private TestMapper testMapper;

    public List<TestEntity> testDao(){
        return testMapper.getAlldata();
    }
}
