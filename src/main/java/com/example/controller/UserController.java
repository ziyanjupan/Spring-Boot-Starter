package com.example.controller;

import com.example.pojo.IMoocJSONResult;
import com.example.pojo.SysUser;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

//Spring MVC风格
//@RestController=@Controller+@ResponseBody
@RestController
//@Controller
@RequestMapping("user")
public class UserController {
    //    @ResponseBody//指明返回json
    @RequestMapping("/getUser")
    public SysUser getUser() {
        SysUser u = new SysUser();
        u.setName("Sam Zhu");
        u.setPassword("12434");
        u.setBirthday(new Date());
        u.setAge(18);
        u.setDesc("test");
        return u;
    }


    @RequestMapping("/getUserJson")
    public IMoocJSONResult getUserJson() {
        SysUser u = new SysUser();
        u.setName("Sam Zhu");
        u.setBirthday(new Date());
        u.setAge(18);
        u.setPassword("12434");
        u.setDesc("test");
        return IMoocJSONResult.ok(u);
    }

}
