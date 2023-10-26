<%@ page import="com.vii.springbootservlet.entity.Employee" %>
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html>
<head>
    <style>
        table {
            font-family: arial, sans-serif;
            border-collapse: collapse;
            width: 100%;
        }

        td, th {
            border: 1px solid #dddddd;
            text-align: left;
            padding: 8px;
        }

        tr:nth-child(even) {
            background-color: #dddddd;
        }
    </style>
</head>
<body>

<h2>HTML Table</h2>
<%
    //    Employee employee = (Employee)request.getAttribute("employee");

    List<Employee> employeeList = (List<Employee>) request.getAttribute("employeeList");
    if (employeeList != null && !employeeList.isEmpty()) {
        for (Employee employee : employeeList) {
%>
<table>
    <tr>
        <th>EmpId</th>
        <th>FirstName</th>
        <th>Last Name</th>
        <th>Salary</th>
        <th>Address</th>
    </tr>
    <tr>
        <td><%=employee.getId()%>
        </td>
        <td><%=employee.getFirstName()%>
        </td>
        <td><%=employee.getLastName()%>
        </td>
        <td><%=employee.getSalary()%>
        </td>
        <td><%=employee.getAddress()%>
        </td>
    </tr>
</table>

<%
    }
} else {
%>
<p>No employees found.</p>
<%
    }
%>

</body>
</html>