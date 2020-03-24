package com.ascending.learning.debug.repository;

import com.ascending.learning.debug.model.Department;

import java.util.List;

public interface DepartmentDao {
        Department save(Department department);
        Department update(Department department);
        boolean delete(String departmentName);
        boolean delete(Department department);
        Department getDepartmentEagerBy(Long id);
        Department getDepartmentLazyBy(Long id);
        List<Department> getDepartments();
}
