package hibernateAnno.maren;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import hibernateAnno.maren.config.HibernateUtil;
import hibernateAnno.maren.model.Employee;

public class MainApp {

	public static void main(String[] args) {
		SessionFactory sessFact = HibernateUtil.getSessionFactory();
		Session session = sessFact.getCurrentSession();
		org.hibernate.Transaction tr = session.beginTransaction();
		Employee emp = new Employee();
		emp.setName("Maren Somers");
		emp.setMobile("000000");
		emp.setAddress("LA - USA");
		session.save(emp);
		tr.commit();
		System.out.println("Successfully inserted");
		sessFact.close();

	}

}
