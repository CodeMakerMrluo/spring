package com.cache.service.impl;

import com.cache.dao.UserInfoMapper;
import com.cache.domain.UserInfo;
import com.cache.service.UserServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Administrator
 * @Title: UserInfoServiceImpl
 * @ProjectName eclipse
 * @Description: TODO
 * @date 2018/7/1 00011:34
 */
public class UserInfoServiceImpl implements UserServiceI {

    /**
    　* @Description: @Autowired 使用标注userMapper变量，需要使用UserMapper时，Spring就会自动注入UserMapper
      */
    @Autowired
    private UserInfoMapper mapper;
    public List<UserInfo> getUser() {
        return mapper.selectAllUserInfo();
    }

}
