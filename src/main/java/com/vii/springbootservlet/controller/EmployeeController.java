package com.vii.springbootservlet.controller;

import com.vii.springbootservlet.entity.Employee;
import com.vii.springbootservlet.service.EmployeeServiceImplement;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "Servlet", urlPatterns = {"/employeeController"})
public class EmployeeController extends HttpServlet {

    private final static Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    private EmployeeServiceImplement employeeService;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fname = req.getParameter("fname");
        LOGGER.info(fname);
        String empId = req.getParameter("empId");
        LOGGER.info(empId);
        List<Employee> employeeList = null;

        Employee employeeInfo = null;
        if (empId != null && empId.trim().length() > 0) {
            employeeInfo = employeeService.getEmployee(Integer.parseInt(empId));
            req.setAttribute("employee", employeeInfo);
            RequestDispatcher employeeView = req.getRequestDispatcher("/employeeView.jsp");
            employeeView.include(req, resp);
        } else if (fname != null && fname.trim().length() > 0) {
            employeeList = employeeService.getEmployeeList(fname);
            req.setAttribute("employeeList", employeeList);

            RequestDispatcher employeeListView = req.getRequestDispatcher("/employeeView.jsp");
            employeeListView.forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

}