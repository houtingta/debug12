package com.ascending.learning.debug.jdbc;

import com.ascending.learning.debug.model.Employee;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class EmployeeJDBCDaoTest {
    private EmployeeJDBCDao employeeDao;

    //Set up
    @Before
    public void init(){
        employeeDao = new EmployeeJDBCDao();
    }

    //Test get method
    @Test
    public void getEmployeesTest(){
        List<Employee> employees = employeeDao.getEmployees();
        int expectedNumOfEmp = 4;

        Assert.assertEquals(expectedNumOfEmp, employees.size());
    }

    //Test insert method
    @Test
    public void insertEmployeesTest(){

    }

    //Test update method
    @Test
    public void updateEmployeesTest(){

    }

    //Test delete method
    @Test
    public void deleteEmployeesTest(){

    }
}
