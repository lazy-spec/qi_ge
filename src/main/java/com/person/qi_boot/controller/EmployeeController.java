package com.person.qi_boot.controller;


import com.person.qi_boot.consts.AjaxResult;
import com.person.qi_boot.domain.Employee;
import com.person.qi_boot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("employee")
public class EmployeeController {

    @Autowired private EmployeeService employeeService;

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

}
