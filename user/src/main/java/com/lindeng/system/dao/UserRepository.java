package com.lindeng.system.dao;

import com.lindeng.enums.StatusEnum;
import com.lindeng.system.dto.Role;
import com.lindeng.system.dto.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface UserRepository extends JpaRepository<User,String>{

    @Query("from User u group by u.status,u.userName")
    Page<User> getAll(Pageable pageable);

    User getByUserName(String userName);

    Page<User> getAllByDepartmentIdAndStatusIsLessThanEqualOrderByStatusAsc(String deptId, StatusEnum status, Pageable pageable);
    User getUserById(String userId);
    Page<User> getAllByStatusIsLessThanEqualOrderByStatusAsc(StatusEnum status, Pageable pageable);
    Page<User> getAllByStatusEqualsOrderByUserNameAsc(StatusEnum status, Pageable pageable);
    Page<User> getAllByRolesContainsAndStatusIsLessThanEqualOrderByStatusAsc(Role role, StatusEnum status, Pageable pageable);
}
