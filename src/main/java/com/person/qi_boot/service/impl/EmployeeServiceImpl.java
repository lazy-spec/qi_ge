package com.person.qi_boot.service.impl;

import com.person.qi_boot.dao.EmployeeDao;
import com.person.qi_boot.domain.Employee;
import com.person.qi_boot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    @Override
    public List<Employee> getEmployeeList() {
        return employeeDao.getList();
    }

    @Override
    public List<Employee> getEmployeeLikeList(String key) {
        return employeeDao.getLikeList(key);
    }

    @Override
    public Employee getEmployeeInfo(Integer id) {
        return employeeDao.getInfoById(id);
    }

    @Override
    public void updateEmployeeInfo(Employee employee) {
        employeeDao.updateById(employee);
    }

    @Override
    public void insertEmployeeInfo(Employee employee) {
        employeeDao.save(employee);
    }

    @Override
    public void deletedById(Integer id) {
        employeeDao.deleteById(id);
    }

    @Override
    public Employee login(String username, String password) {
        return employeeDao.login(username, password);
    }
}
