package com.example.controller;

import com.example.pojo.IMoocJSONResult;
import com.example.pojo.SysUser;
import com.example.utils.JsonUtils;
import com.example.utils.RedisOperator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("redis")
public class RedisController {
    @Autowired
    private StringRedisTemplate strRedis;

    @Autowired
    private RedisOperator redis;

    @RequestMapping("/test")
    public IMoocJSONResult test() {
        strRedis.opsForValue().set("my-cache", "hello xia");
        return IMoocJSONResult.ok(strRedis.opsForValue().get("my-cache"));
    }

    @RequestMapping("/getJson")
    public IMoocJSONResult getJson(){
        SysUser user = new SysUser();
        user.setId(123);
        user.setName("fenix2121");
        user.setAge(26);
        user.setPhone("187324234");
        strRedis.opsForValue().set("jsonObj", JsonUtils.objectToJson(user));
        return IMoocJSONResult.ok(JsonUtils.jsonToPojo(strRedis.opsForValue().get("jsonObj"),SysUser.class));
    }

    @RequestMapping("/getJsonList")
    public IMoocJSONResult getJsonList(){
        SysUser user = new SysUser();
        user.setId(122);
        user.setName("2121");
        user.setAge(2);
        user.setPhone("18732234");

        SysUser u2 = new SysUser();
        u2.setId(13);
        u2.setName("2121");
        u2.setAge(2);
        u2.setPhone("18732234");

        SysUser u1 = new SysUser();
        u1.setId(14);
        u1.setName("2121");
        u1.setAge(2);
        u1.setPhone("18732234");


        List<SysUser> userList = new ArrayList<>();
        userList.add(user);
        userList.add(u1);
        userList.add(u2);

        redis.set("jsonObjList2",JsonUtils.objectToJson(userList),2000);
//        strRedis.opsForValue().set("jsonObjList", JsonUtils.objectToJson(user));
        return IMoocJSONResult.ok(JsonUtils.jsonToList(redis.get("jsonObjList2"),SysUser.class));
    }
}
