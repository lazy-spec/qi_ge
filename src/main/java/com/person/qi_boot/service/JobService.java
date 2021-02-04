package com.person.qi_boot.service;


import com.person.qi_boot.domain.Job;

import java.util.List;

public interface JobService {

    List<Job> findAllJob();

    List<Job> findAllJobByKey(String key);

    Job getJobInfo(Integer id);

    void updateJobInfo(Job job);

    void insertJobInfo(Job job);

    void deleteById(Integer id);

}
