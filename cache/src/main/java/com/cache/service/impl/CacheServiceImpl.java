package com.cache.service.impl;

import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cache.domain.UserInfo;
import com.cache.service.CacheServiceI;
import com.cache.service.UserServiceI;
import netscape.javascript.JSObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Administrator
 * @Title: CacheServiceImpl
 * @ProjectName eclipse
 * @Description: TODO
 * @date 2018/7/1 00013:10
 */
public class CacheServiceImpl implements CacheServiceI {

    @Resource
    public RedisTemplate redisTemplate;

    @Autowired
    public UserServiceI userServiceI;

    public final static String CACHE_KEY = "userInfo";

    public List<UserInfo> getUser() {

        ValueOperations ops = redisTemplate.opsForValue();
        // 1.查询缓存
        String json = String.valueOf(ops.get(CACHE_KEY));// JSON

        List<UserInfo> userInfos = new ArrayList<UserInfo>();
        if(!StringUtils.isEmpty(json)) {
            userInfos = (List<UserInfo>)JSONArray.parseArray(String.valueOf(redisTemplate.opsForValue().get("userInfo")), UserInfo.class);
            if( !userInfos.isEmpty()){
                System.out.printf("取缓存");
                return userInfos;
            }
        }
        //取数据库
        userInfos = userServiceI.getUser();
        redisTemplate.opsForValue().set("userInfo", JSONObject.toJSON(userInfos));
        return userInfos;
    }

    public static void main(String[] args) {
        //CacheServiceImpl impkl = new CacheServiceImpl();
        //impkl.getUser();
        System.out.println(Integer.toBinaryString(15));
        // 二元 >> 相当于/2 << 相当*2
        System.out.println("15 >>> 1   " + (15 << 1));

    }

}
