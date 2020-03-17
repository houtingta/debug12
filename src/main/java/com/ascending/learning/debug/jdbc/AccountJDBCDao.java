package com.ascending.learning.debug.jdbc;

import com.ascending.learning.debug.model.Account;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccountJDBCDao {
    private Logger logger = LoggerFactory.getLogger(getClass());
    //Step 1: Put database information
    static final String DBURL = "jdbc:postgresql://localhost:5430/supermarket";
    static final String USER = "admin";
    static final String PASS = "password";

    public List<Account> getAccounts() {
        List<Account> accounts = new ArrayList();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            //STEP 2: Open a connection
//            System.out.println("Connecting to database...");
            logger.debug("Connercting to database...");
            conn = DriverManager.getConnection(DBURL, USER, PASS);
            //STEP 3: Execute a query
//            System.out.println("Creating statement...");
            logger.info("Creating statement...");
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT * FROM account";
            logger.warn(sql);
            rs = stmt.executeQuery(sql);
            //STEP 4: Extract data from result set
            while(rs.next()) {
                //Retrieve by column name
                Long id  = rs.getLong("id");
                String type = rs.getString("type");
                float balance = rs.getFloat("balance");
                long employeeId = rs.getLong("employee_Id");
                //Fill the object
                Account account = new Account();
                account.setID(id);
                account.setType(type);
                account.setBalance(balance);
                account.setEmployeeId(employeeId);
                accounts.add(account);
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

        return accounts;

    }

    //        Normal Test: Print out (Not good
    public static void main(String[] args) {
        AccountJDBCDao accountJDBCDao = new AccountJDBCDao();
        System.out.println(accountJDBCDao.getAccounts().size());
    }
}
