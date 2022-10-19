package com.infinite.hib;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;


public class AgentDeleteMain {
	public static void main(String[] args) {
		int agentId;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Agent Id");
		agentId=sc.nextInt();
		Configuration cfg=new AnnotationConfiguration().configure();
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Query query = session.createQuery("from Agent where agentId=" +agentId);
		List<Agent> agentList=query.list();
		if(agentList.size()==1)
		{
			Transaction trans= session.beginTransaction();
			session.delete(agentList.get(0));
			trans.commit();
			System.out.println(agentList.get(0));
		}
		else
		{
			System.out.println("record deleted");
		}
}
}