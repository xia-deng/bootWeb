package com.lindeng.system.dao;

import com.lindeng.system.dto.Department;
import org.springframework.data.repository.CrudRepository;

public interface DeptRepository extends CrudRepository<Department,String>{
}
