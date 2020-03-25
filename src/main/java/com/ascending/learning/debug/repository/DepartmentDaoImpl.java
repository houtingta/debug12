package com.ascending.learning.debug.repository;

import com.ascending.learning.debug.model.Department;
import com.ascending.learning.debug.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


//For example: DepartmentDao dd = new DepartmentDaoImpl();
@Repository
public class DepartmentDaoImpl implements DepartmentDao{

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public Department save(Department department) {
        Transaction transaction = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            session.save(department);
            transaction.commit();
            session.close();
            return department;
        }
        catch (Exception e){
            if (transaction != null) transaction.rollback();
            logger.error("failure to insert record", e);
            session.close();
            return null;
        }

    }

    @Override
    public Department update(Department department) {
        return null;
    }

    @Override
    public boolean delete(String departmentName) {
        return false;
    }

    @Override
    public boolean delete(Department department) {
        //:Id placeholder
        String hql = "DELETE Department as department where department.id = :Id";
        int deletedCount = 0;
        Transaction transaction = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
            transaction = session.beginTransaction();
            Query<Department> query = session.createQuery(hql);
            query.setParameter("Id", department.getId());
            deletedCount = query.executeUpdate();
            transaction.commit();;
            session.close();
            return deletedCount >= 1 ? true : false;
        }
        catch (HibernateException e){
            if (transaction != null) transaction.rollback();
            session.close();
            logger.error("unable to delete record",e);
        }
        return false;
    }

    @Override
    public Department getDepartmentEagerBy(Long id) {
        String hql = "FROM Department d LEFT JOIN FETCH d.employees where d.id= :Id";
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            Query<Department> query = session.createQuery(hql);
            query.setParameter("Id",id);
            Department result = query.uniqueResult();
            session.close();
            return result;
        }catch (HibernateException e){
            logger.error("failure to retrieve data record",e);
            session.close();
            return null;
        }
    }

    @Override
    public Department getDepartmentLazyBy(Long id) {
        String hql = "FROM Department d where d.id= :Id";
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            Query<Department> query = session.createQuery(hql);
            query.setParameter("Id",id);
            Department result = query.uniqueResult();
            session.close();
            return result;
        }catch (HibernateException e){
            logger.error("failure to retrieve data record",e);
            session.close();
            return null;
        }
    }

    @Override
    public List<Department> getDepartments() {
        List<Department> departments = new ArrayList<>();
        String hql = "FROM Department";
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            Query<Department> query = session.createQuery(hql);
            departments = query.list();
            session.close();
            return departments;
        }catch (HibernateException e){
            logger.error("failure to retrieve data record",e);
            session.close();
            return departments;
        }
    }
}
