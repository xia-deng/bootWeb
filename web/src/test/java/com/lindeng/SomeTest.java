package com.lindeng;

import com.lindeng.enums.UserStatusEnum;
import com.lindeng.system.dao.UserRepository;
import com.lindeng.system.dto.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.UUID;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Start.class)
public class SomeTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void test(){
        User user = new User();
        user.setId(UUID.randomUUID().toString());
        user.setDepartmentId(UUID.randomUUID().toString());
        user.setPassWord("123");
        user.setSalt("calst");
        user.setUserName("tom");
        user.setStatus(UserStatusEnum.INACTIVE);
        userRepository.save(user);

//        User user1 = userRepository.getUserById(1L);
//
//        System.out.println("save a new user:"+user1);User user1 = userRepository.getUserById(1L);
//
//        System.out.println("save a new user:"+user1);

        List<User> users = userRepository.getAllByStatusIsLessThanOrderByStatusAsc(UserStatusEnum.DELETED);
        for (User user2: users){

            System.out.println("get all user ,and there is a user is:"+user2);
        }
    }
}
