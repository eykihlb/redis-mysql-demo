package com.example.redisdemo.service.impl;

import com.example.redisdemo.dao.UserMapper;
import com.example.redisdemo.entity.User;
import com.example.redisdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @program: redis-demo
 * @description:
 * @author: Eyki
 * @create: 2019-03-20 18:14
 **/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Override
    public int deleteByPrimaryKey(Long id) {
        return 0;
    }

    @Override
    public int insert(User record) {
        return 0;
    }

    @Override
    public int insertSelective(User record) {
        return 0;
    }

    @Cacheable(value="user",key="'user'+#id.toString()")
    @Override
    public User selectByPrimaryKey(Long id) {
        System.out.println("走的数据库");
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(User record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(User record) {
        return 0;
    }
}
