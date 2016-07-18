package fr.adaming.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import fr.adaming.dao.CompteDaoImpl;
import fr.adaming.dao.IClientDao;
import fr.adaming.dao.ICompteDao;
import fr.adaming.model.Client;

public class Test2 {

	public static void main(String[] args) {
		ApplicationContext ctx = new FileSystemXmlApplicationContext("src/main/webapp/WEB-INF/applicationContext.xml");

		IClientDao clientDao = (IClientDao) ctx.getBean("clientDao");
		
		List<Client> cl = clientDao.getAllClients();
		System.out.println(cl);
	}

}
