package com.lindeng.system.dao;

import com.lindeng.enums.SourceTypeEnum;
import com.lindeng.system.dto.Source;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface SourceRepository extends JpaRepository<Source,String> {

    Source getById(String id);

    Page<Source> getAllBySourceType(SourceTypeEnum sourceTypeEnum, Pageable pageable);

}
