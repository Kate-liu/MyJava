package org.copydays.rmliu.cache.service;

import org.copydays.rmliu.cache.entity.User;

import java.util.List;

public interface UserService {
    User find(Integer id);

    List<User> list();
}
