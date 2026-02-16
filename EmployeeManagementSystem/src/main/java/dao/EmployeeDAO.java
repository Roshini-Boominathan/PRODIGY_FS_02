package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import model.Employee;
import util.DBConnection;

public class EmployeeDAO {

    // ADD EMPLOYEE
    public static void addEmployee(Employee e) {
        try {
            Connection con = DBConnection.getConnection();
            String sql = "INSERT INTO employee(name, email, department) VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, e.getName());
            ps.setString(2, e.getEmail());
            ps.setString(3, e.getDepartment());
            ps.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    // GET ALL EMPLOYEES
    public static List<Employee> getAllEmployees() {
        List<Employee> list = new ArrayList<>();

        try {
            Connection con = DBConnection.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM employee");

            while (rs.next()) {
                Employee e = new Employee();
                e.setId(rs.getInt("id"));
                e.setName(rs.getString("name"));
                e.setEmail(rs.getString("email"));
                e.setDepartment(rs.getString("department"));
                list.add(e);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return list;
    }

    // DELETE EMPLOYEE
    public static void deleteEmployee(int id) {
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps =
                    con.prepareStatement("DELETE FROM employee WHERE id=?");
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}