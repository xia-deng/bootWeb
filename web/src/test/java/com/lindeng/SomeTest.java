package com.lindeng;

import com.lindeng.enums.StatusEnum;
import com.lindeng.system.dao.DeptRepository;
import com.lindeng.system.dao.UserRepository;
import com.lindeng.system.dto.Department;
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

    @Autowired
    private DeptRepository deptRepository;

    @Test
    public void test(){

//        Department department = new Department();
//        department.setDeptName("测试部门");
//        department.setDeptNumber("001");
//        department.setDescription("这是一个测试用的部门数据");
//        department.setStatus(StatusEnum.INACTIVE);
//        department.setId("4028e381624cd87b01624cd884830001");
//        //deptRepository.save(department);
//        User user = new User();
//        user.setId("4028e381624cd87b01624cd884830000");
//        user.setDepartment(department);
//        user.setPassWord("123");
//        user.setSalt("calst");
//        user.setUserName("NiMaBi");
//        user.setStatus(StatusEnum.INACTIVE);
//        userRepository.saveAndFlush(user);

//        User user1 = userRepository.getUserById(1L);
//
//        System.out.println("save a new user:"+user1);User user1 = userRepository.getUserById(1L);
//
//        System.out.println("save a new user:"+user1);

        List<User> users = userRepository.getAllByStatusIsLessThanOrderByStatusAsc(StatusEnum.DELETED);
        for (User user2: users){

            System.out.println("get all user ,and there is a user is:"+user2);
        }

        deptRepository.findAll().forEach(department1 -> System.out.println(department1));
    }
}
