package com.vii.springbootservlet.service;

import com.vii.springbootservlet.dao.EmployeeDao;
import com.vii.springbootservlet.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class EmployeeServiceImplement implements EmployeeService{

    @Autowired
    private EmployeeDao employeeDao;

    @Override
    public Employee getEmployee(Integer id) {
        System.out.println("Entered geEmployee withId "+ id);
        var employee = employeeDao.findById(id).get();

        if(id == 100){
            employee.setSalary(new BigDecimal(200));
        }
        return employee;
    }

    @Override
    public List<Employee> getEmployeeList(String fullName) {
        var allByFirstName = employeeDao.findByFirstName(fullName);
        return allByFirstName;
    }
}
