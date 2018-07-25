package com.lindeng;

import com.lindeng.enums.StatusEnum;
import com.lindeng.system.dao.DeptRepository;
import com.lindeng.system.dao.RoleRepository;
import com.lindeng.system.dao.UserRepository;
import com.lindeng.system.dto.Department;
import com.lindeng.system.dto.Role;
import com.lindeng.system.dto.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.querydsl.QPageRequest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Start.class)
public class SomeTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DeptRepository deptRepository;

    @Autowired
    private RoleRepository roleRepository;

    private static final String existTemplateId = "ff808181624d7d1a01624d7d23950000";

    @Test
    public void testInsertDepart() {
        Department department = new Department();
        department.setDeptName("测试部门");
        department.setDeptNumber("001");
        department.setDescription("这是一个测试用的部门数据");
        department.setStatus(StatusEnum.INACTIVE);
        Department insertedDept = deptRepository.save(department);
        //ff808181645425f3016454261b6b0000
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
        //ff8081816454299001645429a5190000
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

    @Test
    public void testRolesAndUsers(){
        Role role = new Role();
        role.setRoleName("Normal Role");
        role.setDescription("Every one should has this role");
        roleRepository.save(role);
        System.out.println(role);

        //Role role = roleRepository.getRoleById("ff80818164507f9d0164507fb2330000");
        User user = userRepository.getUserById("ff8081816454299001645429a5190000");
        Set<Role> roleSet = new HashSet<>();
        roleSet.add(role);
        user.setRoles(roleSet);
        user = userRepository.saveAndFlush(user);
        System.out.println("new user have role:" + user);
        Page<User> users = userRepository.getAllByRolesContainsAndStatusIsLessThanEqualOrderByStatusAsc(role, StatusEnum.DELETED, new QPageRequest(1,10));
        users.forEach(user1 -> System.out.println(user1));
    }

    @Test
    public void testGetUser(){
        User user = userRepository.getUserById("ff8081816454299001645429a5190000");
        System.out.println(user);
        Page<User> users = userRepository.getAll(new QPageRequest(1,10));
        System.out.println(users);
    }


}
