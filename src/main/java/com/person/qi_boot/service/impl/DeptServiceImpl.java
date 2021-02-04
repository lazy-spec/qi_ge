package com.person.qi_boot.service.impl;

import com.person.qi_boot.dao.DeptDao;
import com.person.qi_boot.domain.Dept;
import com.person.qi_boot.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptDao deptDao;


    @Override
    public List<Dept> findAllDeptByKey(String key) {
        return deptDao.selectLikeAllDept(key);
    }

    @Override
    public void addDept(Dept dept) {
        deptDao.save(dept);
    }

    @Override
    public void updateById(Dept dept) {
        deptDao.updateInfoById(dept);
    }

    @Override
    public Dept findById(Integer id) {
        return deptDao.getInfoById(id);
    }

    @Override
    public void deleteById(Integer id) {
        deptDao.deletedById(id);
    }

    @Override
    public List<Dept> findAllDept() {
        return deptDao.selectAllDept();
    }
}
