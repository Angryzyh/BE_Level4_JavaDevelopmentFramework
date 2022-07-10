package com.angryzyh.controller;

import com.angryzyh.model.User;
import com.angryzyh.service.UserService;
import com.angryzyh.utils.R;
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
        return new R(userService.save(user));
    }

    //修改用户
    @PutMapping
    public R updateUser(@RequestBody User user) {
        return new R(userService.updateById(user));
    }

    //删除用户
    @DeleteMapping("{id}")
    public R deleteUserById(@PathVariable Long id) {
        return new R(userService.removeById(id));
    }

    //查询单个用户
    @GetMapping("{id}")
    public R getUserById(@PathVariable Long id) {
        return new R(true,userService.getById(id));
    }

    //分页查询
    @GetMapping("{currentPage}/{pageSize}")
    public R getPages(@PathVariable int currentPage, @PathVariable int pageSize) {
        return new R(true, userService.myPage(currentPage, pageSize));
    }

}
