package com.biblioteca.main;

import org.hibernate.Session;

import com.biblioteca.entity.Autor;
import com.biblioteca.service.AutorService;
import com.biblioteca.util.HibernateUtil;

public class Main {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		AutorService autorService = new AutorService(session);
		
		Autor autor = new Autor("German","Avalor", 25);
		
		autorService.save(autor);
		
		autorService.closeSession();
	}
}
