package com.person.qi_boot.controller;

import com.person.qi_boot.consts.AjaxResult;
import com.person.qi_boot.domain.PunchClock;
import com.person.qi_boot.service.PunchClockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("punch")
public class PunchClockController {

    @Autowired
    private PunchClockService punchClockService;
    @Autowired
    private HttpServletRequest request;

    @PostMapping("add")
    public AjaxResult add(@RequestBody PunchClock punchClock) {
        String ip = request.getRemoteAddr();
        punchClock.setIp(ip);
        try {
            punchClockService.addIn(punchClock);
        } catch (Exception e) {
            return AjaxResult.fail().msg(e.getMessage());
        }
        return AjaxResult.ok().msg("打卡成功");
    }

    @PutMapping("update")
    public AjaxResult update(@RequestBody PunchClock punchClock) {
        try {
            punchClockService.upOut(punchClock);
        } catch (Exception e) {
            return AjaxResult.fail().msg(e.getMessage());
        }
        return AjaxResult.ok().msg("签退成功");
    }


    @GetMapping("list")
    public AjaxResult list() {
        return AjaxResult.ok().data("attendances", punchClockService.selectAll());
    }



}
