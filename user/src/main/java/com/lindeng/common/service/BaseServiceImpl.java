package com.lindeng.common.service;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public abstract class BaseServiceImpl<T,ID> implements BaseService<T,ID>{

    public JpaRepository<T,ID> jpaRepository;

    public BaseServiceImpl(JpaRepository<T, ID> jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    public List<T> findAll(){
        return jpaRepository.findAll();
    }

    public <S extends  T> S save(S s){
      return jpaRepository.saveAndFlush(s);
    }

    public <S extends T> S update(S s){
        return jpaRepository.saveAndFlush(s);
    }

    public void delete(ID id){
        jpaRepository.deleteById(id);
    }

    public void delete(List<ID> ids){
       ids.forEach(id -> delete(id));
    }
}
