package com.vii.springbootservlet.view;

import com.vii.springbootservlet.entity.Employee;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "EmployeeListView", urlPatterns = {"/employeeListView"})
public class EmployeeListView extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter writer = response.getWriter();
        List<Employee> employeeList = (List<Employee>)request.getAttribute("employeeList");

        String top = "<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "<style>\n" +
                "table {\n" +
                "  font-family: arial, sans-serif;\n" +
                "  border-collapse: collapse;\n" +
                "  width: 100%;\n" +
                "}\n" +
                "\n" +
                "td, th {\n" +
                "  border: 1px solid #dddddd;\n" +
                "  text-align: left;\n" +
                "  padding: 8px;\n" +
                "}\n" +
                "\n" +
                "tr:nth-child(even) {\n" +
                "  background-color: #dddddd;\n" +
                "}\n" +
                "</style>\n" +
                "</head>\n" +
                "<body>\n" +
                "\n" +
                "<h2>HTML Table</h2>\n" +
                "\n" +
                "<table>\n" +
                "  <tr>\n" +
                "    <th>EmpId</th>\n" +
                "    <th>FirstName</th>\n" +
                "    <th>Last Name</th>\n" +
                "    <th>Salary</th>\n" +
                "    <th>Address</th>\n" +
                "  </tr>\n";

        for (Employee employee : employeeList){
            String loop = "  <tr>\n" +
                    "    <td>"+employee.getId()+"...</td>\n" +
                    "    <td>"+employee.getFirstName()+"</td>\n" +
                    "    <td>"+employee.getLastName()+"</td>\n" +
                    "    <td>"+employee.getSalary()+"</td>\n" +
                    "    <td>"+employee.getAddress()+"</td>\n" +
                    "  </tr>\n";
            top += loop;
        }


        String end=
                "</table>\n" +
                        "\n" +
                        "</body>\n" +
                        "</html>\n";
        String completeHtml = top + end;

        writer.println(completeHtml);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
