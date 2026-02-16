<%@ page import="java.util.List" %>
<%@ page import="dao.EmployeeDAO" %>
<%@ page import="model.Employee" %>

<!DOCTYPE html>
<html>
<head>
    <title>View Employees</title>
</head>
<body>

<h2>Employee List</h2>

<table border="1">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Email</th>
        <th>Department</th>
        <th>Action</th>
    </tr>

<%
    List<Employee> list = EmployeeDAO.getAllEmployees();
    for (Employee e : list) {
%>
    <tr>
        <td><%= e.getId() %></td>
        <td><%= e.getName() %></td>
        <td><%= e.getEmail() %></td>
        <td><%= e.getDepartment() %></td>
        <td>
            <a href="deleteEmployee?id=<%= e.getId() %>">Delete</a>
        </td>
    </tr>
<%
    }
%>

</table>

<br>
<a href="index.jsp">Back to Home</a>

</body>
</html>