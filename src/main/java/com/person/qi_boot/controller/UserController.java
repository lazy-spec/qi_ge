package com.person.qi_boot.controller;


import com.person.qi_boot.consts.AjaxResult;
import com.person.qi_boot.domain.User;
import com.person.qi_boot.service.EmployeeService;
import com.person.qi_boot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired private UserService userService;
    @Autowired private EmployeeService employeeService;

    public static final String USER_SESSION = "user_session";

    @GetMapping("list")
    public AjaxResult list() {
        return AjaxResult.ok().data("users", userService.getUserList());
    }

    @GetMapping("{id}")
    public AjaxResult getById(@PathVariable("id") Integer id) {
        return AjaxResult.ok().data("user", userService.getUserInfo(id));
    }

    @DeleteMapping("{id}")
    public AjaxResult deleteById(@PathVariable("id") Integer id) {
        userService.deletedById(id);
        return AjaxResult.ok();
    }

    @PutMapping("")
    public AjaxResult update(User user) {
        userService.updateUserInfo(user);
        return AjaxResult.ok();
    }

    @PostMapping("")
    public AjaxResult save(User user) {
        userService.insertUserInfo(user);
        return AjaxResult.ok();
    }


    @PostMapping("login")
    public AjaxResult login(User user) {
        User login = userService.login(user.getUsername(), user.getPassword());
        if (null == login) {
            return AjaxResult.fail().msg("用户名或密码错误");
        }
        return AjaxResult.ok();
    }


}
