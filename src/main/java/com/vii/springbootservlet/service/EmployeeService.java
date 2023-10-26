package com.vii.springbootservlet.service;

import com.vii.springbootservlet.entity.Employee;

import java.util.List;

public interface EmployeeService {
    Employee getEmployee(Integer id);
    List<Employee> getEmployeeList(String fullName);
}
