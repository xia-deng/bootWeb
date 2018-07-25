package com.lindeng.system.service;

import com.lindeng.common.service.BaseService;
import com.lindeng.system.dto.Role;
import com.lindeng.system.model.PageParam;
import org.springframework.data.domain.Page;

import java.util.Set;

public interface RoleService extends BaseService<Role,String> {
    Role getRoleById(String roleId);
    Page<Role> getAllByIdIsNotNullOrderByRoleName(PageParam pageParam);
}
