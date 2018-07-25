package com.lindeng.system.service;

import com.lindeng.common.service.BaseService;
import com.lindeng.enums.StatusEnum;
import com.lindeng.system.dto.User;
import com.lindeng.system.model.PageParam;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @author deng
 */
public interface UserService extends BaseService<User,String> {

    Page<User> getAll(PageParam pageParam);

    User getUserById(String userId);

    Page<User> getUsersByStatus(StatusEnum statusEnum, PageParam pageParam);

    Page<User> getUsersByDeptIdAndStatus(String deptId, StatusEnum statusEnum, PageParam pageParam);

    Page<User> getUsersByRoleIdAndStatus(String role, StatusEnum statusEnum, PageParam pageParam);

}
