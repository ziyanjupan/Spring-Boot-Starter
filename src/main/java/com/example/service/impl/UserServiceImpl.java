package com.example.service.impl;

import com.example.mapper.SysUserMapper;
import com.example.mapper.SysUserMapperCustom;
import com.example.pojo.SysUser;
import com.example.service.UserService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.ObjectUtils;
import org.thymeleaf.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Autowired
    private SysUserMapperCustom sysUserMapperCustom;

    @Override
    public void saveUser(SysUser user) throws Exception {
        sysUserMapper.insert(user);
    }

    @Override
    public void updateUser(SysUser user) {
        sysUserMapper.updateByPrimaryKey(user);
    }

    @Override
    public void deleteUser(Integer userId) {
        sysUserMapper.deleteByPrimaryKey(userId);
    }

    @Override
    public SysUser queryUserById(Integer userId) {
        return sysUserMapper.selectByPrimaryKey(userId);
    }

    @Override
    public List<SysUser> queryUserList(SysUser user) {
        Example example = new Example(SysUser.class);
        Example.Criteria criteria = example.createCriteria();

        if (!StringUtils.isEmptyOrWhitespace(user.getName())) {
            criteria.andLike("name", "%" + user.getName() + "%");
        }

        if (!StringUtils.isEmptyOrWhitespace(user.getPhone())) {
            criteria.andLike("phone", "%" + user.getPhone() + "%");
        }

        List<SysUser> userList = sysUserMapper.selectByExample(example);

        return userList;

    }

    @Override
    public List<SysUser> queryPagedUserList(SysUser user,Integer pageIndex,Integer pageSize) {
        PageHelper.startPage(pageIndex,pageSize);
        Example example=new Example(SysUser.class);
        Example.Criteria criteria=example.createCriteria();

        if (!StringUtils.isEmpty(user.getName())){
            criteria.andLike("name","%"+user.getName()+"%");
        }
        example.orderBy("id").desc();

        return sysUserMapper.selectByExample(example);
    }

    @Override
    public SysUser getUserByIdCustom(Integer id) {
        List<SysUser> userList=sysUserMapperCustom.selectById(id);
        if (userList==null||userList.isEmpty()){
            return null;
        }
        return userList.get(0);
    }

    @Override
    public void saveUserTransactional(SysUser user) {
        sysUserMapper.insert(user);

        int a = 1 / 0;

        sysUserMapper.deleteByPrimaryKey(1);
    }
}
