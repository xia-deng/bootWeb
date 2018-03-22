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

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Start.class)
public class SomeTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DeptRepository deptRepository;

    private static final String existTemplateId = "ff808181624d7d1a01624d7d23950000";

    @Test
    public void testInsertDepart() {
        Department department = new Department();
        department.setDeptName("测试部门");
        department.setDeptNumber("001");
        department.setDescription("这是一个测试用的部门数据");
        department.setStatus(StatusEnum.INACTIVE);
        Department insertedDept = deptRepository.save(department);
        System.out.println(deptRepository.getById(insertedDept.getId()));
    }

    @Test
    public void testInsertUser() {
        User user = new User();
        user.setId("4028e381624cd87b01624cd884830000");
        user.setPassWord("123");
        user.setSalt("calst");
        user.setUserName("NiMaBi");
        user.setStatus(StatusEnum.INACTIVE);
        User insertedUser = userRepository.save(user);
        System.out.println(userRepository.getUserById(insertedUser.getId()));
    }

    @Test
    public void testParentDepart() {
        Department department = new Department();
        department.setDeptName("测试部门");
        department.setDeptNumber("001");
        department.setDescription("这是一个测试用的部门数据");
        department.setStatus(StatusEnum.INACTIVE);
        Department insertedDept = deptRepository.save(department);
        Department departmentChild = new Department();
        departmentChild.setDeptName("Child Dept");
        departmentChild.setDeptNumber("1001");
        departmentChild.setDepartLevel(2);
        departmentChild.setStatus(StatusEnum.INACTIVE);
        departmentChild.setDescription("First child dept test");
        departmentChild.setParentDepart(insertedDept);
        departmentChild = deptRepository.save(departmentChild);
        System.out.println(deptRepository.getById(departmentChild.getId()));
    }


}
