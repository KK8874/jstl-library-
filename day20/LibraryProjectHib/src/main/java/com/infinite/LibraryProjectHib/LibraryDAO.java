package com.infinite.LibraryProjectHib;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

public class LibraryDAO {
	SessionFactory sessionFactory;
	public List<Books> searchBooks(String searchtype,String searchvalue){
		sessionFactory=SessionHelper.getConnection();
		Session session=sessionFactory.openSession();
		Criteria cr=session.createCriteria(Books.class);
		if (searchtype.equals("id")) {
			int id =Integer.parseInt(searchvalue);
			cr.add(Restrictions.eq("id", id));
		} 
		if (searchtype.equalsIgnoreCase("dept")) {
			cr.add(Restrictions.eq("dept", searchvalue));
		}

		if (searchtype.equalsIgnoreCase("bookname")) {
			cr.add(Restrictions.eq("name", searchvalue));
		}

		if (searchtype.equalsIgnoreCase("authorname")) {
			cr.add(Restrictions.eq("author", searchvalue));
		}

		List<Books> lst = cr.list();
			return lst;
	}


	public int loginCheck(String userName, String passWord) {
		sessionFactory = SessionHelper.getConnection();
		Session session = sessionFactory.openSession(); 
		Criteria cr = session.createCriteria(Books.class);
		cr.add(Restrictions.eq("userName", userName));
		cr.add(Restrictions.eq("passWord", passWord));
		List<Books> listUsers = cr.list();
		return listUsers.size();
	}
		
	

}
