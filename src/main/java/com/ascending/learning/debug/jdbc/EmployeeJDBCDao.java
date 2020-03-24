package com.ascending.learning.debug.jdbc;

import com.ascending.learning.debug.model.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeJDBCDao {
    private Logger logger = LoggerFactory.getLogger(getClass());
    //Step 1: Put database information
    static final String DBURL = "jdbc:postgresql://localhost:5430/supermarket";
    static final String USER = "admin";
    static final String PASS = "password";

    public List<Employee> getEmployees() {
        List<Employee> employees = new ArrayList();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            //STEP 2: Open a connection
            System.out.println("Connecting to database...");
            logger.debug("Connercting to database...");
            conn = DriverManager.getConnection(DBURL, USER, PASS);
            //STEP 3: Execute a query
            System.out.println("Creating statement...");
            logger.info("Creating statement...");
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT * FROM employee";
            logger.warn(sql);
            rs = stmt.executeQuery(sql);
            //STEP 4: Extract data from result set
            while(rs.next()) {
                //Retrieve by column name
                Long id  = rs.getLong("id");
                String name = rs.getString("name");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                String email = rs.getString("email");
                String address = rs.getString("address");
                int age = rs.getInt("age");
                float salary = rs.getFloat("salary");
                Long departmentId = rs.getLong("department_id");

                //Fill the object
                Employee employee = new Employee();
                employee.setId(id);
                employee.setName(name);
                employee.setFirstName(firstName);
                employee.setLastName(lastName);
                employee.setEmail(email);
                employee.setAddress(address);
                employee.setAge(age);
                employee.setSalary(salary);
                //employee.setDepartment(departmentId);
                employees.add(employee);
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        finally {
            //STEP 6: finally block used to close resources
            try {
                if(rs != null) rs.close();
                if(stmt != null) stmt.close();
                if(conn != null) conn.close();
            }
            catch(SQLException se) {
                se.printStackTrace();
            }
        }

        return employees;

    }

//    //        Normal Test: Print out (Not good
//    public static void main(String[] args) {
//        EmployeeJDBCDao employeeJDBCDao = new EmployeeJDBCDao();
//        System.out.println(employeeJDBCDao.getEmployees().size());
//    }
}

