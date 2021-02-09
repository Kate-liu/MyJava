package org.copydays.rmliu.cache.service;

import org.copydays.rmliu.cache.entity.User;
import org.copydays.rmliu.cache.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserMapper userMapper;

    @Override
    public User find(Integer id) {
        return userMapper.find(id);
    }

    @Override
    public List<User> list() {
        return userMapper.list();
    }
}
