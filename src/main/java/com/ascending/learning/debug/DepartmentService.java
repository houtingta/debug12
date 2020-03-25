package com.ascending.learning.debug;

import com.ascending.learning.debug.model.Department;
import com.ascending.learning.debug.repository.DepartmentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {
    //@Autowired private Logger logger;
    @Autowired
    private DepartmentDao departmentDao;

    public Department save(Department department) {
        department.setName(department.getName()+department.getLocation());
        Department d1 = departmentDao.save(department);
        return d1;
    }

    public Department update(Department department) { return departmentDao.update(department); }

    public boolean delete(String deptName) { return departmentDao.delete(deptName); }

    public List<Department> getDepartment() { return departmentDao.getDepartments(); }

//    boolean delete(Department department);
//    Department getDepartmentEagerBy(Long id);
//    Department getDepartmentLazyBy(Long id);
//
}
