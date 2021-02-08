package com.person.qi_boot.service;


import com.person.qi_boot.domain.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> getEmployeeList();
    List<Employee> getEmployeeLikeList(String key);
    Employee getEmployeeInfo(Integer id);
    void updateEmployeeInfo(Employee employee);
    void insertEmployeeInfo(Employee employee);
    void deletedById(Integer id);
    Employee login(String cardId, String password, Integer roleId);

}
