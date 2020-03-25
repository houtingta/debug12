package com.ascending.learning.debug.repository;

import com.ascending.learning.debug.init.AppBootstrap;
import com.ascending.learning.debug.model.Department;
import org.hibernate.HibernateException;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.swing.*;
import java.util.List;

//@RunWith(Spring.class)
@SpringBootTest(classes= AppBootstrap.class)
public class DepartmentDaoTest {
    @Autowired
    private DepartmentDao departmentDao;
//    @Autowired
//    private EmployeeDao employeeDao;

//    private DepartmentDao departmentDao;
    private Department d1;
    private String depString = "HR1";

    @Before
    public void init(){
        departmentDao = new DepartmentDaoImpl();
        d1 = new Department();
        d1.setName(depString);
        d1.setDescription("save test!");
        d1.setLocation("US");
        d1=departmentDao.save(d1);
    }
    @After
    public void tearDown(){
        departmentDao.delete(d1);
    }

    @Test(expected = HibernateException.class)
    public void getDepartmentsTest(){
        Department department = departmentDao.getDepartmentLazyBy(d1.getId());
//        int expectedNumOfDept = 4;
        Assert.assertNotNull(department);
        Assert.assertTrue(department.getEmployees().size()>0);
    }

    @Test
    public void getDepartmentEagerByTest(){
        Department department = departmentDao.getDepartmentEagerBy(d1.getId());
        Assert.assertNotNull(department);
        Assert.assertEquals(department.getName(),d1.getName());
        Assert.assertTrue(department.getEmployees().size()>0);
    }

}
