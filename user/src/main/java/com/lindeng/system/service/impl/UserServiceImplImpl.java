package com.lindeng.system.service.impl;

import com.lindeng.common.service.BaseServiceImpl;
import com.lindeng.enums.StatusEnum;
import com.lindeng.system.dao.UserRepository;
import com.lindeng.system.dto.Role;
import com.lindeng.system.dto.User;
import com.lindeng.system.model.PageParam;
import com.lindeng.system.service.RoleService;
import com.lindeng.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QPageRequest;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.List;
import java.util.Objects;

@Service
public class UserServiceImplImpl extends BaseServiceImpl<User, String> implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleService roleService;

    public UserServiceImplImpl(JpaRepository<User, String> userRepository) {
        super(userRepository);
    }

    @Override
    public Page<User> getAll(PageParam pageParam) {
        return userRepository.getAll(new QPageRequest(pageParam.getPageIndex(), pageParam.getPageSize()));
    }

    @Override
    public User getUserById(String userId) {
        return userRepository.getUserById(userId);
    }

    @Override
    public Page<User> getUsersByStatus(StatusEnum statusEnum, PageParam pageParam) {
        return userRepository.getAllByStatusEqualsOrderByUserNameAsc(statusEnum
                , new QPageRequest(pageParam.getPageIndex(), pageParam.getPageSize()));
    }

    @Override
    public Page<User> getUsersByDeptIdAndStatus(String deptId, StatusEnum statusEnum, PageParam pageParam) {
        statusEnum = Objects.equals(null, statusEnum) ? StatusEnum.DELETED : statusEnum;
        return userRepository.getAllByDepartmentIdAndStatusIsLessThanEqualOrderByStatusAsc(deptId, statusEnum
                , new QPageRequest(pageParam.getPageIndex(), pageParam.getPageSize()));
    }

    @Override
    public Page<User> getUsersByRoleIdAndStatus(String roleId, StatusEnum statusEnum, PageParam pageParam) {
        Role role = roleService.getRoleById(roleId);
        return userRepository.getAllByRolesContainsAndStatusIsLessThanEqualOrderByStatusAsc(role, statusEnum
                , new QPageRequest(pageParam.getPageIndex(), pageParam.getPageSize()));
    }
}
