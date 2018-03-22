package com.lindeng.system.dao;

import com.lindeng.enums.UserStatusEnum;
import com.lindeng.system.dto.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Long>{
    List<User> getAllByDepartmentIdAndStatusIsLessThanOrderByStatusAsc (Long deptId, UserStatusEnum status);
    User getUserById(Long userId);
    List<User> getAllByStatusIsLessThanOrderByStatusAsc (UserStatusEnum status);

}
