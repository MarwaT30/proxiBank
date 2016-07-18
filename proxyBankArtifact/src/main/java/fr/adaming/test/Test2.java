package fr.adaming.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import fr.adaming.dao.CompteDaoImpl;
import fr.adaming.dao.ICompteDao;

public class Test2 {

	public static void main(String[] args) {
		ApplicationContext ctx = new FileSystemXmlApplicationContext("src/main/webapp/WEB-INF/applicationContext.xml");

		ICompteDao compteDao = new CompteDaoImpl();
		
		System.out.println(compteDao.getCompteCourantByNumero(88));
		
	}

}
