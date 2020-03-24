package com.ascending.learning.debug.repository;

import com.ascending.learning.debug.model.Department;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class DepartmentDaoTest {
    private DepartmentDao departmentDao;
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

    @Test
    public void getDepartmentsTest(){
        List<Department> departments = departmentDao.getDepartments();
        int expectedNumOfDept = 5;

        Assert.assertEquals(expectedNumOfDept, departments.size());
    }

    @Test
    public void getDepartmentEagerByTest(){
        Department department = departmentDao.getDepartmentEagerBy(d1.getId());
        Assert.assertNotNull(department);
        Assert.assertEquals(department.getName(),d1.getName());
        Assert.assertTrue(department.getEmployees().size()==0);
    }

}
