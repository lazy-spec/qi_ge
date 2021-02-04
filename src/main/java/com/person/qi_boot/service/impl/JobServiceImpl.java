package com.person.qi_boot.service.impl;

import com.person.qi_boot.dao.JobDao;
import com.person.qi_boot.domain.Job;
import com.person.qi_boot.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobServiceImpl implements JobService {

    @Autowired private JobDao jobDao;

    @Override
    public List<Job> findAllJob() {
        return jobDao.getList();
    }

    @Override
    public List<Job> findAllJobByKey(String key) {
        return jobDao.getLikeList(key);
    }

    @Override
    public Job getJobInfo(Integer id) {
        return jobDao.getInfoById(id);
    }

    @Override
    public void updateJobInfo(Job job) {
        jobDao.updateById(job);
    }

    @Override
    public void insertJobInfo(Job job) {
        jobDao.save(job);
    }

    @Override
    public void deleteById(Integer id) {
        jobDao.deleteById(id);
    }
}
