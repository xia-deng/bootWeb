package com.lindeng.system.dao;

import com.lindeng.system.dto.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role,String>{

    Role getRoleById(String roleId);
}
