package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import util.DBConnection;

@WebServlet("/testdb")
public class TestDBServlet extends HttpServlet {
	
	  @Override
	    protected void doGet(HttpServletRequest req, HttpServletResponse res)
	            throws ServletException, IOException {

	        res.setContentType("text/html");
	        PrintWriter out = res.getWriter();

	        Connection con = DBConnection.getConnection();

	        if (con != null) {
	            out.println("<h2>✅ Database Connected Successfully!</h2>");
	        } else {
	            out.println("<h2>❌ Database Connection Failed</h2>");
	        }
	    }
}
