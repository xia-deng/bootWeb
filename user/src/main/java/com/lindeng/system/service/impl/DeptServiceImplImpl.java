package com.lindeng.system.service.impl;

import com.lindeng.common.service.BaseServiceImpl;
import com.lindeng.system.dao.DeptRepository;
import com.lindeng.system.dto.Department;
import com.lindeng.system.model.PageParam;
import com.lindeng.system.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QPageRequest;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class DeptServiceImplImpl extends BaseServiceImpl<Department, String> implements DeptService {

    private DeptRepository deptRepository;

    @Autowired
    public DeptServiceImplImpl(JpaRepository<Department, String> deptRepository) {
        super(deptRepository);
    }

    @Override
    public Department getById(String deptId) {
        return deptRepository.getById(deptId);
    }

    @Override
    public Page<Department> getAllByIdIsNotNullOrderByDeptNumber(PageParam pageParam) {
        return deptRepository.getAllByIdIsNotNullOrderByDeptNumber(new QPageRequest(pageParam.getPageIndex(), pageParam.getPageSize()));
    }
}
