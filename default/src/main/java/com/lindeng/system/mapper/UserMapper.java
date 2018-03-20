`package com.lindeng.system.mapper;

import com.lindeng.system.dao.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @Select("select * from t_sys_user where user_name=#{name}")
    User findByName(@Param("name") String name);
}
