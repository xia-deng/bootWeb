package com.lindeng.system.dao;

import com.lindeng.enums.StatusEnum;
import com.lindeng.system.dto.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User,String>{
    List<User> getAllByDepartmentIdAndStatusIsLessThanOrderByStatusAsc (String deptId, StatusEnum status);
    User getUserById(String userId);
    List<User> getAllByStatusIsLessThanOrderByStatusAsc (StatusEnum status);

}
