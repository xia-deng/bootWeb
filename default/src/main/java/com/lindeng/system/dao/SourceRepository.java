package com.lindeng.system.dao;

import com.lindeng.enums.SourceTypeEnum;
import com.lindeng.system.dto.Source;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface SourceRepository extends CrudRepository<Source,String>{

    Source getById(String id);

    Set<Source> getAllBySourceType(SourceTypeEnum sourceTypeEnum);

}
