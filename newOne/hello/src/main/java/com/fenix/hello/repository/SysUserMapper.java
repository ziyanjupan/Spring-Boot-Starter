package com.fenix.hello.repository;

import com.fenix.hello.model.SysUser;

import java.util.List;

public interface SysUserMapper {
    SysUser selectByPrimaryKey(Integer id);

    SysUser selectByName(String name);

    List<SysUser> selectPagedUser();
}
