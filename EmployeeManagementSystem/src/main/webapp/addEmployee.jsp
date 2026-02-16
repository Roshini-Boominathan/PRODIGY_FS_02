<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Employee</title>
</head>
<body>
<h2>Add Employee</h2>

<form action="addEmployee" method="post">
    Name: <input type="text" name="name" required><br><br>
    Email: <input type="email" name="email" required><br><br>
    Department: <input type="text" name="department"><br><br>
    Salary: <input type="number" name="salary" required><br><br>

    <button type="submit">Add Employee</button>
</form>

<br>
<a href="viewEmployee.jsp">View Employees</a>
</body>
</html>