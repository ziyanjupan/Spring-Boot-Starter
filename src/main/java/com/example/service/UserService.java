package com.example.service;

import com.example.pojo.SysUser;

import java.util.List;

public interface UserService {
    public void saveUser(SysUser user) throws Exception;

    public void updateUser(SysUser user);

    public void deleteUser(Integer userId);

    public SysUser queryUserById(Integer userId);

    public List<SysUser> queryUserList(SysUser user);

    public List<SysUser> queryPagedUserList(SysUser user,Integer pageIndex,Integer pageSize);

}
