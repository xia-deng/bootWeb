package com.lindeng.common.service;

import java.util.List;

public interface BaseService<T, ID> {
    List<T> findAll();
    <S extends  T> S save(S s);
    <S extends T> S update(S s);
    void delete(ID id);
    void delete(List<ID> ids);
}
