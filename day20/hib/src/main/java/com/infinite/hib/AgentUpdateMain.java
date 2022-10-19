package com.infinite.hib;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;



public class AgentUpdateMain {
	public static void main(String[] args) {
		Agent agent = new Agent();
		Scanner sc= new Scanner(System.in);

		System.out.println("enter agent Id");
		agent.setAgentId(sc.nextInt());
		System.out.println("enter agent name");
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
		Query query = session.createQuery("from Agent where agentId=" +agent.getAgentId());
		List<Agent> agentList=query.list();
		session.close();
		if(agentList.size()==1)
		{
			session=sf.openSession();
			Transaction trans= session.beginTransaction();
			session.saveOrUpdate(agent);
			trans.commit();
			System.out.println("*** Record Updated ***");
		} else {
			System.out.println("*** Record not Found ***");
		}
	}
		
}
