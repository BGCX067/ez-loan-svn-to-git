package com.ez.common.util;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.ContextLoader;

import com.ez.admin.service.impl.BankServiceImpl;

public class DummyDataListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		//This is you Spring Root Web application context
		ApplicationContext applicationContext=ContextLoader.getCurrentWebApplicationContext();
		 //access service layer using bean name or qualifier name
		//
		BankServiceImpl bankServiceImpl=(BankServiceImpl)applicationContext.getBean("BankServiceImpl");
		bankServiceImpl.show();
		System.out.println(bankServiceImpl);
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		
	}

}
