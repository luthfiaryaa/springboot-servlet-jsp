package com.vii.springbootservlet.dao;

import com.vii.springbootservlet.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeDao extends JpaRepository<Employee, Integer> {
    public List<Employee> findByFirstName(String fullName);
    public List<Employee> findAllByFirstNameAndLastName(String fullName, String lastName);
}
