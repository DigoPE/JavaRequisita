package com.projetorodrigo.util;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class CarregaSessao implements ServletContextListener {

	//Esse metodo � chamado quando PARAR o TomCat.
	@Override
	public void contextDestroyed(ServletContextEvent arg0){
		HibernateUtil.getSessionFactory().close();
		
	}
	
	//Esse metodo � chamado quando INICIA o TomCat.
	@Override
	public void contextInitialized(ServletContextEvent arg0){
		HibernateUtil.getSessionFactory().openSession();
	}
	
}
