package org.copydays.rmliu.cache.service;

import org.copydays.rmliu.cache.entity.User;
import org.springframework.cache.annotation.CacheConfig;

import java.util.List;

@CacheConfig(cacheNames = "users")
public interface UserService {
    User find(Integer id);

    List<User> list();
}
