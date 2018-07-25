package com.lindeng.system.dao;

import com.lindeng.system.dto.Department;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface DeptRepository extends JpaRepository<Department,String> {

    Department getById(String deptId);

    Page<Department> getAllByIdIsNotNullOrderByDeptNumber(Pageable pageable);
}
