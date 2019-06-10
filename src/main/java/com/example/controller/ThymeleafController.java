package com.example.controller;

import com.example.pojo.User;
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
        User user = new User();
        user.setName("superadmin");
        user.setAge(10);
        user.setPassword("123465");
        user.setBirthday(new Date());
        user.setDesc("<font color='green'><b>hello imooc</b></font>");

        map.addAttribute("user", user);
        return "thymeleaf/test";
    }
}
