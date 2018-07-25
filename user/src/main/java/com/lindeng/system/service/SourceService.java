package com.lindeng.system.service;

import com.lindeng.common.service.BaseService;
import com.lindeng.enums.SourceTypeEnum;
import com.lindeng.system.dto.Source;
import com.lindeng.system.model.PageParam;
import org.springframework.data.domain.Page;

import java.util.Set;

public interface SourceService extends BaseService<Source,String> {
    Source getById(String id);

    Page<Source> getAllBySourceType(SourceTypeEnum sourceTypeEnum, PageParam pageParam);
}
