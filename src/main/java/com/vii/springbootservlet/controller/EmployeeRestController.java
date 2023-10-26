//package com.vii.springbootservlet.controller;
//
//import com.vii.springbootservlet.entity.Employee;
//import com.vii.springbootservlet.service.EmployeeServiceImplement;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class EmployeeRestController {
//
//    @Autowired
//    private EmployeeServiceImplement empService;
//
//    @GetMapping("/restemp")
//    public Employee getEmpById(@RequestParam(value = "id") Integer id){
//        var employee =h empService.getEmployee(id);
//        return employee;
//    }
//}
