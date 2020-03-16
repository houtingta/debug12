package com.ascending.learning.debug.jdbc;

import com.ascending.learning.debug.model.Department;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDao {
    private Logger logger = LoggerFactory.getLogger(getClass());
    //Step 1: Put database information
    static final String DBURL = "jdbc:postgresql://localhost:5430/supermarket";
    static final String USER = "admin";
    static final String PASS = "password";

    public List<Department> getDepartments() {
        List<Department> departments = new ArrayList();
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
            sql = "SELECT * FROM department";
            logger.warn(sql);
            rs = stmt.executeQuery(sql);
            //STEP 4: Extract data from result set
            while(rs.next()) {
                //Retrieve by column name
                Long id  = rs.getLong("id");
                String name = rs.getString("name");
                String description = rs.getString("description");
                String location = rs.getString("location");
                //Fill the object
                Department department = new Department();
                department.setId(id);
                department.setName(name);
                department.setDescription(description);
                department.setLocation(location);
                departments.add(department);
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

        return departments;

    }

//        Normal Test: Print out (Not good
    public static void main(String[] args) {
        DepartmentDao departmentDao = new DepartmentDao();
        System.out.println(departmentDao.getDepartments().size());
    }
}
