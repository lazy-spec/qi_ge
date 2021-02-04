package com.person.qi_boot.service;

import com.person.qi_boot.domain.Dept;

import java.util.List;

public interface DeptService {
    List<Dept> findAllDeptByKey(String key);

    void addDept(Dept dept);
    void updateById(Dept dept);

    Dept findById(Integer id);

    void deleteById(Integer id);

    List<Dept> findAllDept();
}
