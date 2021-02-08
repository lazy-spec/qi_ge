package com.person.qi_boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("login")
    public String login() {
        return "login";
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("dept/index")
    public String deptIndex() {
        return "dept/index";
    }

    @GetMapping({"dept/add", "dept/edit"})
    public String dept() {
        return "dept/add";
    }

    @GetMapping("downloadcenter/index")
    public String downloadCenter() {
        return "downloadcenter/index";
    }

    @GetMapping("downloadcenter/add")
    public String downloadAdd() {
        return "downloadcenter/upload";
    }

    @GetMapping("employee/index")
    public String employeeIndex() {
        return "employee/index";
    }

    @GetMapping("employee/add")
    public String empAdd() {
        return "employee/add";
    }

    @GetMapping("position/index")
    public String positionIndex() {
        return "position/index";
    }

    @GetMapping("position/add")
    public String positionAdd() {
        return "position/add";
    }

    @GetMapping("attendance/index")
    public String attendanceIndex() {
        return "attendance/index";
    }

    @GetMapping("attendance")
    public String attendance() {
        return "attendance/punch";
    }

}
