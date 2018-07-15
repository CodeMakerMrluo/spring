package com.cache.service;

import com.cache.domain.UserInfo;

import java.util.List;

/**
 * @author Administrator
 * @Title: UserServiceI
 * @ProjectName eclipse
 * @Description: TODO
 * @date 2018/7/1 00011:33
 */
public interface UserServiceI {

    /**
    　* @Description: 查询所有用户
      * @return ${List<UserInfo>}
      */
    List<UserInfo> getUser();
}
