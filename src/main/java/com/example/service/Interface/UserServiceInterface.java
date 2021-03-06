package com.example.service.Interface;

import com.example.pojo.SysUser;

import java.util.List;

public interface UserServiceInterface {
    public void saveUser(SysUser user);
    public void updateUser(SysUser user);
    public void deleteUser(String userId);
    public SysUser queryUserById(String userId);
    public List<SysUser> queryUserList(SysUser user);
    public List<SysUser> queryUserListPaged(SysUser user, Integer page, Integer pageSize);
    public SysUser queryUserByIdCustom(String userId);
    public void saveUserTransactional(SysUser user);
}
