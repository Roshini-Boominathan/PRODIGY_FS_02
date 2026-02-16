package servlet;

import java.io.IOException;

import dao.EmployeeDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Employee;

@WebServlet("/addEmployee")

public class AddEmployeeServlet extends HttpServlet {
	
	 @Override
	    protected void doPost(HttpServletRequest req, HttpServletResponse res)
	            throws ServletException, IOException {

	        // 1️⃣ Create Employee object
	        Employee e = new Employee();

	        // 2️⃣ Read form data
	        e.setName(req.getParameter("name"));
	        e.setEmail(req.getParameter("email"));
	        e.setDepartment(req.getParameter("department"));
	        e.setSalary(Double.parseDouble(req.getParameter("salary")));

	        // 3️⃣ Call DAO to save data
	        try {
	            EmployeeDAO.addEmployee(e);

	            // 4️⃣ Redirect to view page
	            res.sendRedirect("viewEmployee.jsp");

	        } catch (Exception ex) {
	            ex.printStackTrace();
	        }
	    }
}
