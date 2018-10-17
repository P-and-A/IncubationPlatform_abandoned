package com.incubationplatform.service;

import com.incubationplatform.dao.TestDao;
import com.incubationplatform.entity.TestEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by GMUK on 2018/10/17 0017.
 */
@Service
public class TestService {
    @Autowired
    private TestDao testDao;
    public List<TestEntity> testService(){
        return testDao.testDao();
    }
}
