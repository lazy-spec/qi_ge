package com.person.qi_boot.controller;

import com.person.qi_boot.consts.AjaxResult;
import com.person.qi_boot.domain.Dept;
import com.person.qi_boot.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("dept")
public class DeptController {

    @Autowired private DeptService deptService;

    @GetMapping("list")
    public AjaxResult list() {
        return AjaxResult.ok().data("departments", deptService.findAllDept());
    }

    @GetMapping("{id}")
    public AjaxResult getById(@PathVariable("id") Integer id) {
        return AjaxResult.ok().data("dept", deptService.findById(id));
    }

    @DeleteMapping("{id}")
    public AjaxResult deleteById(@PathVariable("id") Integer id) {
        deptService.deleteById(id);
        return AjaxResult.ok();
    }

    @PutMapping("")
    public AjaxResult update(@RequestBody Dept dept) {
        deptService.updateById(dept);
        return AjaxResult.ok();
    }

    @PostMapping("")
    public AjaxResult save(@RequestBody Dept dept) {
        deptService.addDept(dept);
        return AjaxResult.ok();
    }



}
