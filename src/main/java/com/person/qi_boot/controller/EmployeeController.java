package com.person.qi_boot.controller;


import com.person.qi_boot.consts.AjaxResult;
import com.person.qi_boot.consts.Const;
import com.person.qi_boot.domain.Employee;
import com.person.qi_boot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Objects;

@RestController
@RequestMapping("employee")
public class EmployeeController {

    @Autowired private EmployeeService employeeService;
    @Autowired private HttpSession session;

    @GetMapping("list")
    public AjaxResult list() {
        return AjaxResult.ok().data("employees", employeeService.getEmployeeList());
    }

    @GetMapping("{id}")
    public AjaxResult getById(@PathVariable("id") Integer id) {
        return AjaxResult.ok().data("employee", employeeService.getEmployeeInfo(id));
    }

    @DeleteMapping("{id}")
    public AjaxResult deleteById(@PathVariable("id") Integer id) {
        employeeService.deletedById(id);
        return AjaxResult.ok();
    }

    @PutMapping("")
    public AjaxResult update(Employee employee) {
        employeeService.updateEmployeeInfo(employee);
        return AjaxResult.ok();
    }

    @PostMapping("")
    public AjaxResult save(Employee employee) {
        employeeService.insertEmployeeInfo(employee);
        return AjaxResult.ok();
    }

    @PostMapping("login")
    public AjaxResult login(@RequestBody Employee employee) {
        Employee login = employeeService.login(employee.getCardId(), employee.getPassword(), employee.getRoleId());
        if (Objects.isNull(login)) {
            return AjaxResult.fail().msg("账号不存在或密码错误");
        }
        login.setPassword(null);
        session.setAttribute(Const.EMP_SESSION, login);
        return AjaxResult.ok().data("employee", login);
    }

    @PostMapping("logout")
    public AjaxResult logout() {
        session.removeAttribute(Const.EMP_SESSION);
        return AjaxResult.ok().msg("退出成功");
    }

}
