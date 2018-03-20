package com.lindeng;

import com.lindeng.system.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Start.class)
public class TestUser {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void findByName() {
        userMapper.findByName("AAA");
    }
}
