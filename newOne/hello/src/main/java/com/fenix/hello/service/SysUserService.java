package com.fenix.hello.service;

import com.fenix.hello.model.SysUser;

import java.util.List;

public interface SysUserService {
	public SysUser getUserById(Integer userId);
	public SysUser getUserByName(String name);

	public List<SysUser> listUser(int page,int pageSize);
}
