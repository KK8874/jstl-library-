package com.infinite.HibDemos;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class EmployUpdateMain {
public static void main(String[] args) {
	Employ employ = new Employ();
	Scanner sc= new Scanner(System.in);

	System.out.println("enter employ number");
	employ.setEmpno(sc.nextInt());
	System.out.println("enter employ name");
	employ.setName(sc.next());
	System.out.println("enter department");
	employ.setDept(sc.next());
	System.out.println("enter designation");
	employ.setDesig(sc.next());
	System.out.println("enter basic");
	employ.setBasic(sc.nextInt());
	Configuration cfg=new AnnotationConfiguration().configure();
	SessionFactory sf = cfg.buildSessionFactory();
	Session session = sf.openSession();
	Query query = session.createQuery("from Employ where empno=" +employ.getEmpno());
	List<Employ> employList=query.list();
	session.close();
	if(employList.size()==1)
	{
		session=sf.openSession();
		Transaction trans= session.beginTransaction();
		session.saveOrUpdate(employ);
		trans.commit();
		System.out.println("*** Record Updated ***");
	} else {
		System.out.println("*** Record not Found ***");
	}
}
	
}

