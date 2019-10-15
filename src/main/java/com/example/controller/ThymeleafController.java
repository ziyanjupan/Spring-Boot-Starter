package com.example.controller;

import com.example.pojo.SysUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@Controller
@RequestMapping("th")
public class ThymeleafController {
    @RequestMapping("index")
    public String index(ModelMap map) {
        map.addAttribute("name", "thymeleaf-imooc");
        return "thymeleaf/index";
    }

    @RequestMapping("center")
    public String center() {
        return "thymeleaf/center/center";
    }

    @RequestMapping("test")
    public String test(ModelMap map) {
        SysUser sysUser = new SysUser();
        sysUser.setName("superadmin");
        sysUser.setAge(10);
        sysUser.setPassword("123465");
        sysUser.setBirthday(new Date());
        sysUser.setDesc("<font color='green'><b>hello imooc</b></font>");

        map.addAttribute("user", sysUser);
        return "thymeleaf/test";
    }
}
