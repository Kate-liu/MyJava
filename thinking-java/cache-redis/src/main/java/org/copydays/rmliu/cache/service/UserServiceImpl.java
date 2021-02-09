package org.copydays.rmliu.cache.service;

import org.copydays.rmliu.cache.entity.User;
import org.copydays.rmliu.cache.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserMapper userMapper;

    @Override
//    @Cacheable(key = "#id", value = "userCache")  // 开启 spring cache, spring cache 作用在方法上
//    @Cacheable  // 不自定义 缓存 key 的名字，使用全局 org.copydays.rmliu.cache.CacheConfig.keyGenerator() 定义的方法
    public User find(Integer id) {
        System.out.println("===> find" + id);  // 演示缓存是否走 AOP 拦截，一旦缓存就不会继续调用这个方法
        return userMapper.find(id);
    }

    @Override
//    @Cacheable(key = "methodName", value = "userCache")  // 开启 spring cache
//    @Cacheable  // 不自定义 缓存 key 的名字，使用全局 org.copydays.rmliu.cache.CacheConfig.keyGenerator() 定义的方法
    public List<User> list() {
        return userMapper.list();
    }
}
