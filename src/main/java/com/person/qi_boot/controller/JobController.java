package com.person.qi_boot.controller;

import com.person.qi_boot.consts.AjaxResult;
import com.person.qi_boot.domain.Employee;
import com.person.qi_boot.domain.Job;
import com.person.qi_boot.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @desc:
 * @author: zhangshengjun
 * @createDate: 2021/2/4
 */
@RestController
@RequestMapping("job")
public class JobController {

    @Autowired private JobService jobService;

    @GetMapping("list")
    public AjaxResult list() {
        return AjaxResult.ok().data("jobs", jobService.findAllJob());
    }

    @GetMapping("{id}")
    public AjaxResult getById(@PathVariable("id") Integer id) {
        return AjaxResult.ok().data("job", jobService.getJobInfo(id));
    }

    @DeleteMapping("{id}")
    public AjaxResult deleteById(@PathVariable("id") Integer id) {
        jobService.deleteById(id);
        return AjaxResult.ok();
    }

    @PutMapping("")
    public AjaxResult update(@RequestBody Job job) {
        jobService.updateJobInfo(job);
        return AjaxResult.ok();
    }

    @PostMapping("")
    public AjaxResult save(@RequestBody Job job) {
        jobService.insertJobInfo(job);
        return AjaxResult.ok();
    }
}
