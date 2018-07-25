package com.lindeng.system.service.impl;

import com.lindeng.common.service.BaseServiceImpl;
import com.lindeng.enums.SourceTypeEnum;
import com.lindeng.system.dao.SourceRepository;
import com.lindeng.system.dto.Source;
import com.lindeng.system.model.PageParam;
import com.lindeng.system.service.SourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QPageRequest;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class SourceServiceImplImpl extends BaseServiceImpl<Source, String> implements SourceService {

    private SourceRepository sourceRepository;

    @Autowired
    public SourceServiceImplImpl(JpaRepository<Source, String> sourceRepository) {
        super(sourceRepository);
    }


    @Override
    public Source getById(String id) {
        return sourceRepository.getById(id);
    }

    @Override
    public Page<Source> getAllBySourceType(SourceTypeEnum sourceTypeEnum, PageParam pageParam) {
        return sourceRepository.getAllBySourceType(sourceTypeEnum
                , new QPageRequest(pageParam.getPageIndex(), pageParam.getPageSize()));
    }
}
