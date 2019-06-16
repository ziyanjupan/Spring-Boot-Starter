package com.fenix.hello.service.impl;

import com.fenix.hello.model.SysUser;
import com.fenix.hello.repository.SysUserMapper;
import com.fenix.hello.service.SysUserService;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("sysUserService")
public class SysUserServiceImpl implements SysUserService {

    @Resource
    private SysUserMapper sysUserMapper;

    @Override
    public SysUser getUserById(Integer userId) {
        SysUser sysUser = sysUserMapper.selectByPrimaryKey(userId);
        return sysUser;
    }

    @Override
    public SysUser getUserByName(String name) {
        SysUser sysUser = sysUserMapper.selectByName(name);
        return sysUser;
    }

    @Override
    public List<SysUser> listUser(int page, int pageSize) {
        List<SysUser> result = null;
        try {
            // 调用pagehelper分页，采用starPage方式。starPage应放在Mapper查询函数之前
            PageHelper.startPage(page, pageSize);
            PageHelper.orderBy("id");
            result = sysUserMapper.selectPagedUser();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
