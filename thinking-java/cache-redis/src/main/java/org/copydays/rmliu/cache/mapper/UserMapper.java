package org.copydays.rmliu.cache.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.copydays.rmliu.cache.entity.User;

import java.util.List;

@Mapper
public interface UserMapper {

    User find(Integer id);

    List<User> list();
}
