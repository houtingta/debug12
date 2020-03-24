package com.ascending.learning.debug.jdbc;

import com.ascending.learning.debug.model.Department;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class DepartmentJDBCDaoTest {
    private DepartmentJDBCDao departmentJDBCDao;
    private Logger logger = LoggerFactory.getLogger(getClass());

    //Set up
    @Before
    public void init () {
        departmentJDBCDao = new DepartmentJDBCDao();
    }

    //Test get method
    @Test
    public void getDepartmentsTest(){
        List<Department> departments = departmentJDBCDao.getDepartments();
        //check the number of records
        int expectedNumOfDept = 4;

//        for(Department department : departments){
//            System.out.println(department);
//        }

        Assert.assertEquals(expectedNumOfDept, departments.size());
    }

    //Test insert method
    @Test
    public void insertDepartmentsTest(){

    }

    //Test update method
    @Test
    public void updateDepartmentsTest(){

    }

    //Test delete method
    @Test
    public void deleteDepartmentsTest(){

    }
}
