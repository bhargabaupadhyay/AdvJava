package com.cutm.Hibernate1;

import org.hibernate.Session;

import com.cutm.Hibernate1.model.Employee;
import com.cutm.Hibernate1.utils.HibernateUtil;

/**
 * Hibernate Program using XML
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
 
        session.beginTransaction();
        Employee emp = new Employee();
        emp.setEmpId(3);
        emp.setName("upadhyay");
        emp.setAddress("jharkhand");
        emp.setMobile("8825163537");
        session.save(emp);
        session.getTransaction().commit();
        System.out.println("Great! Student was saved");
    }
}
