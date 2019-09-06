package com.example.mapper;

import com.example.pojo.SysUser;

import java.util.List;

public interface SysUserMapperCustom {
    List<SysUser> selectById(Integer id);
}
