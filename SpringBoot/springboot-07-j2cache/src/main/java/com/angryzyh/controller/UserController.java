package com.angryzyh.controller;

import com.angryzyh.controller.utils.R;
import com.angryzyh.model.User;
import com.angryzyh.service.UserService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    //查询全部用户
    @GetMapping
    public R getAllUser() {
        return new R(true,userService.list());
    }

    //添加用户
    @PostMapping
    public R saveUser(@RequestBody User user) {
        boolean flag = userService.save(user);
        return new R(flag, flag ? "添加成功^_^" : "添加失败-_-!");
    }

    //修改用户
    @PutMapping
    public R updateUser(@RequestBody User user) {
        boolean flag = userService.updateById(user);
        return new R(flag, flag ? "修改成功^_^" : "修改失败-_-!");
    }

    //删除用户
    @DeleteMapping("{id}")
    public R deleteUserById(@PathVariable String id) {
        boolean flag = userService.removeById(id);
        return new R(flag, flag ? "删除成功^_^" : "删除失败-_-!");
    }

    //查询单个用户
    @GetMapping("{id}")
    public R getUserById(@PathVariable String id) {
        return new R(true,userService.getById(id));
    }

    //分页 模糊查询
    @GetMapping("{currentPage}/{pageSize}")
    public R getPages(@PathVariable int currentPage, @PathVariable int pageSize, User user) {
        Page<User> userPage = userService.myPage(currentPage, pageSize, user);
        if (currentPage > userPage.getPages()) {
            userPage = userService.myPage((int) userPage.getPages(), pageSize, user);
        }
        return new R(true, userPage);
    }

}
