package com.ascending.learning.debug.jdbc;

import com.ascending.learning.debug.model.Department;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class DepartmentDaoTest {
    private DepartmentDao departmentDao;
    private Logger logger = LoggerFactory.getLogger(getClass());

    //Setup
    @Before
    public void init () {departmentDao = new DepartmentDao();}

    //Unit test method
    @Test
    public void getDepartmentsTest(){
        List<Department> departments = departmentDao.getDepartments();
        int expectedNumOfDept = 4;
        logger.debug("Connercting to database...");
//        for(Department department : departments){
//            System.out.println(department);
//        }

        Assert.assertEquals(expectedNumOfDept, departments.size());
    }
}
