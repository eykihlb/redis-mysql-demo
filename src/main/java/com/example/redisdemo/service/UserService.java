package com.example.redisdemo.service;

import com.example.redisdemo.entity.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @program: redis-demo
 * @description:
 * @author: Eyki
 * @create: 2019-03-20 18:14
 **/
@Component
public interface UserService {

    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}
