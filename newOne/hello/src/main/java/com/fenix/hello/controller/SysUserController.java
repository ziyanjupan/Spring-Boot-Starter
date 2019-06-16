package com.fenix.hello.controller;

import com.fenix.hello.model.SysUser;
import com.fenix.hello.service.SysUserService;
import com.github.pagehelper.PageInfo;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@EnableAutoConfiguration
@RequestMapping("/sysUser")
public class SysUserController {
    @Resource
    private SysUserService sysUserService;

    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = "application/json")
    public SysUser getSysUser(@PathVariable Integer id) throws Exception {
        SysUser sysUser = sysUserService.getUserById(id);
        return sysUser;
    }

    @RequestMapping(value = "/getSysUserByName", method = RequestMethod.GET, produces = "application/json")
    public SysUser getSysUserByName() throws Exception {
        SysUser sysUser = sysUserService.getUserByName("三");
        return sysUser;
    }

    @RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
    public PageInfo<SysUser> listSysUser(@RequestParam(value = "page", required = false, defaultValue = "1") int page,
                                         @RequestParam(value = "page-size", required = false, defaultValue = "5") int pageSize) {
        List<SysUser> result = sysUserService.listUser(page, pageSize);

        PageInfo<SysUser> pi = new PageInfo<SysUser>(result);
        return pi;
    }
}
