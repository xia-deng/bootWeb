package com.lindeng.system.dao;

import com.lindeng.system.dto.Role;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface RoleRepository extends JpaRepository<Role,String> {

    Role getRoleById(String roleId);

    Page<Role> getAllByIdIsNotNullOrderByRoleName(Pageable pageable);
}
