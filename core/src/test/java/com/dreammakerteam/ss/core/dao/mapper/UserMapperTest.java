package com.dreammakerteam.ss.core.dao.mapper;

import com.dreammakerteam.ss.core.TestApplication;
import com.dreammakerteam.ss.core.dao.api.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UserMapperTest {
//
    @Autowired
    private UserMapper userMapper;
//    @Autowired
//    private UserRepository userRepository;

    @Test
    public void findById() {
//        System.out.println(userRepository.findById(1L).orElse(null));
        System.out.println(userMapper.findById(1L));
    }
}