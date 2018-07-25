package com.lindeng.system.service;

import com.lindeng.common.service.BaseService;
import com.lindeng.system.dto.Department;
import com.lindeng.system.model.PageParam;
import org.springframework.data.domain.Page;

public interface DeptService extends BaseService<Department,String>{
    Department getById(String deptId);
    Page<Department> getAllByIdIsNotNullOrderByDeptNumber(PageParam pageParam);
}
