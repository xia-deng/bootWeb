package com.lindeng.system.service.impl;

import com.lindeng.common.service.BaseServiceImpl;
import com.lindeng.system.dao.RoleRepository;
import com.lindeng.system.dto.Role;
import com.lindeng.system.model.PageParam;
import com.lindeng.system.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QPageRequest;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class RoleServiceImplImpl extends BaseServiceImpl<Role, String> implements RoleService {

    private RoleRepository roleRepository;

    @Autowired
    public RoleServiceImplImpl(JpaRepository<Role, String> roleRepository) {
        super(roleRepository);
    }


    @Override
    public Role getRoleById(String roleId) {
        return roleRepository.getRoleById(roleId);
    }

    @Override
    public Page<Role> getAllByIdIsNotNullOrderByRoleName(PageParam pageParam) {
        return roleRepository.getAllByIdIsNotNullOrderByRoleName(new QPageRequest(pageParam.getPageIndex(), pageParam.getPageSize()));
    }
}
