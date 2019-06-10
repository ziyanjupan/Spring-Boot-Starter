package com.example.controller;

import com.example.pojo.IMoocJSONResult;
import com.example.pojo.Resource;
import com.fasterxml.jackson.databind.util.BeanUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@ComponentScan
@RestController
public class HelloController {

    @Autowired
    private Resource resource;

    @RequestMapping("/hello")
    public String Hello() {
        return "Hello World!";
    }

    @RequestMapping("/getResource")
    public IMoocJSONResult getResource() {
        Resource bean = new Resource();
        BeanUtils.copyProperties(resource, bean);

        return IMoocJSONResult.ok(bean);
    }
}
