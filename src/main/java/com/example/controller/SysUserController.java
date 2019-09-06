package com.example.controller;

import com.example.pojo.IMoocJSONResult;
import com.example.pojo.SysUser;
import com.example.service.UserService;
import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("mybatis")
public class SysUserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/saveUser")
    public IMoocJSONResult saveUser() throws Exception {

//        String userId = sid.nextShort();

        SysUser user = new SysUser();
        user.setId(324);
        user.setName("imooc" + new Date());
        user.setAge(16);
        user.setPhone("1232543");
        userService.saveUser(user);

        return IMoocJSONResult.ok("保存成功");
    }

    @RequestMapping("/updateUser")
    public IMoocJSONResult updateUset() throws Exception {
        SysUser user = new SysUser();
        user.setId(324);
        user.setName("fenix");
        user.setAge(26);
        user.setPhone("187324234");
        userService.updateUser(user);

        return IMoocJSONResult.ok("修改成功");
    }

    @RequestMapping("/deleteUser")
    public IMoocJSONResult deleteUser() throws Exception {
        userService.deleteUser(324);
        return IMoocJSONResult.ok("删除成功");
    }

    @RequestMapping("/queryUserById")
    public IMoocJSONResult getUserById(Integer id) throws Exception {
        return IMoocJSONResult.ok(userService.queryUserById(id));
    }

    @RequestMapping("/userList")
    public IMoocJSONResult getUsers() throws Exception {
        SysUser user = new SysUser();
        user.setName("abc");

        return IMoocJSONResult.ok(userService.queryUserList(user));

    }

    @RequestMapping("/pagedUserList")
    public IMoocJSONResult getPagedUsers(Integer pageIndex) throws Exception {
        if (pageIndex == null) {
            pageIndex = 1;
        }
        int pageSize=5;
        SysUser user = new SysUser();
        user.setName("abc");

        return IMoocJSONResult.ok(userService.queryPagedUserList(user,pageIndex,pageSize));

    }

    @RequestMapping("/getUserByIdCustom")
    public IMoocJSONResult getUser(Integer id) throws  Exception{
        try {
            SysUser user=userService.getUserByIdCustom(id);
            return IMoocJSONResult.ok(user);
        }catch (Exception e){
            return IMoocJSONResult.errorException(e.getMessage());
        }

    }

    @RequestMapping("/saveUserTransactional")
    @Transactional(propagation = Propagation.REQUIRED)
    public IMoocJSONResult saveUserTransactional() {
        SysUser user = new SysUser();
        user.setId(12);
        user.setName("fenix121");
        user.setAge(26);
        user.setPhone("187324234");
        userService.saveUserTransactional(user);
        return IMoocJSONResult.ok("保存成功");
    }
}
