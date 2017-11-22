package com.biblioteca.service;

import org.hibernate.Session;

import com.biblioteca.dao.AutorDaoImpl;
import com.biblioteca.entity.Autor;

public class AutorService {
	private AutorDaoImpl autorDao;
	
	public AutorService(Session session) {
		autorDao = new AutorDaoImpl(session);
	}
	
	public void save(Autor autor) {
		autorDao.save(autor);
	}
	
	public void closeSession() {
		autorDao.closeSession();
	}
}
