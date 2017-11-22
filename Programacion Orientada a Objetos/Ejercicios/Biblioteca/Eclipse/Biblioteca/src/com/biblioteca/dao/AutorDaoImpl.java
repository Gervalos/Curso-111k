package com.biblioteca.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.biblioteca.entity.Autor;

public class AutorDaoImpl implements AutorDao {
	
	private Session session;
	
	public AutorDaoImpl(Session session) {
		this.session = session;
	}

	@Override
	public void save(Autor autor) {
		Transaction tx = null;
		
		try {
			tx = session.beginTransaction();
			
			session.save(autor);
			
			tx.commit();
		}
		catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}
	}
	
	public void closeSession() {
		session.close();
	}
}
