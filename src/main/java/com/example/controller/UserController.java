package com.example.controller;

import com.example.pojo.SysUser;
import com.example.pojo.User;
import com.example.service.Interface.UserServiceInterface;
import com.example.utils.BBResult;
import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;


@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserServiceInterface userService;
    @Autowired
    private Sid sid;

    @GetMapping("/getUser")
    public User getUser() {
        User u = new User();
        u.setAge(12);
        u.setBirthday(new Date());
        u.setName("imooc");
        u.setPassword("imooc");
        u.setDesc("hello springboot~");

        return u;
    }

    @GetMapping("/getUserJson")
    public BBResult getUserJson() {
        User u = new User();
        u.setAge(12);
        u.setBirthday(new Date());
        u.setName("imooc");
        u.setPassword("imooc");
        u.setDesc("h");
        BBResult result = BBResult.ok(u);
        return result;
    }

    @RequestMapping("/saveUser")
    public BBResult saveUser() {
        String userId = sid.nextShort();
        SysUser user = new SysUser();
        user.setId(userId);
        user.setUsername("imooc" + new Date());
        user.setNickname("imooc" + new Date());
        user.setPassword("abc123");
        user.setIsDelete(0);
        user.setRegistTime(new Date());
        userService.saveUser(user);
        return BBResult.ok("保存成功");
    }

    @RequestMapping("/updateUser")
    public BBResult updateUser() {

        SysUser user = new SysUser();
        user.setId("10011001");
        user.setUsername("10011001-updated" + new Date());
        user.setNickname("10011001-updated" + new Date());
        user.setPassword("10011001-updated");
        user.setIsDelete(0);
        user.setRegistTime(new Date());

        userService.updateUser(user);

        return BBResult.ok("保存成功");
    }

    @RequestMapping("/deleteUser")
    public BBResult deleteUser(String userId) {

        userService.deleteUser(userId);

        return BBResult.ok("删除成功");
    }

    @RequestMapping("/queryUserById")
    public BBResult queryUserById(String userId) {

        return BBResult.ok(userService.queryUserById(userId));
    }

    @RequestMapping("/queryUserList")
    public BBResult queryUserList() {

        SysUser user = new SysUser();
        user.setUsername("imooc");
        user.setNickname("lee");

        List<SysUser> userList = userService.queryUserList(user);

        return BBResult.ok(userList);
    }

    @RequestMapping("/queryUserListPaged")
    public BBResult queryUserListPaged(Integer page) {
        if (page == null) {
            page = 1;
        }
        int pageSize = 10;
        SysUser user = new SysUser();
        List<SysUser> userList = userService.queryUserListPaged(user, page, pageSize);

        return BBResult.ok(userList);
    }

    @RequestMapping("/queryUserByIdCustom")
    public BBResult queryUserByIdCustom(String userId) {

        return BBResult.ok(userService.queryUserByIdCustom(userId));
    }

    @RequestMapping("/saveUserTransactional")
    public BBResult saveUserTransactional() {

        String userId = sid.nextShort();

        SysUser user = new SysUser();
        user.setId(userId);
        user.setUsername("lee" + new Date());
        user.setNickname("lee" + new Date());
        user.setPassword("abc123");

        user.setIsDelete(0);
        user.setRegistTime(new Date());
        userService.saveUserTransactional(user);

        return BBResult.ok("保存成功");
    }

}
