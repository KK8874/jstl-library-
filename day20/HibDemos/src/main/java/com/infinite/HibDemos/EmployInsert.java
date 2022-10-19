package com.infinite.HibDemos;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class EmployInsert {
public static void main(String[] args) {
	Employ employ = new Employ();
	Scanner sc= new Scanner(System.in);
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
	Transaction trans= session.beginTransaction();
	session.save(employ);
	trans.commit();
	System.out.println("record inserted");
}
}
