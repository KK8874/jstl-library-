package com.infinite.hib;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;


public class AgentInsertMain {
	public static void main(String[] args) {
		Agent agent = new Agent();
		Scanner sc= new Scanner(System.in);
		System.out.println("enter Agent Name");
		agent.setName(sc.next());
		System.out.println("enter city");
		agent.setCity(sc.next());
		System.out.println("enter martialStatus");
		agent.setMaritalStatus(sc.next());
		System.out.println("enter premium");
		agent.setPremium(sc.nextDouble());
		Configuration cfg=new AnnotationConfiguration().configure();
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction trans= session.beginTransaction();
		session.save(agent);
		trans.commit();
		System.out.println("record inserted");
}
}
