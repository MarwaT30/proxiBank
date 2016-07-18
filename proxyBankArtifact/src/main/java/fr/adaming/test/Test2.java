package fr.adaming.test;

import java.sql.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import fr.adaming.dao.CompteDaoImpl;
import fr.adaming.dao.IAgenceDao;
import fr.adaming.dao.IClientDao;
import fr.adaming.dao.ICompteDao;
import fr.adaming.dao.IConseillerDao;
import fr.adaming.dao.IGerantDao;
import fr.adaming.model.Agence;
import fr.adaming.model.Client;
import fr.adaming.model.ConseillerClientele;

public class Test2 {

	public static void main(String[] args) {
		ApplicationContext ctx = new FileSystemXmlApplicationContext("src/main/webapp/WEB-INF/applicationContext.xml");
		IGerantDao gerantDao = (IGerantDao) ctx.getBean("gerantDao");
		IAgenceDao agenceDao = (IAgenceDao) ctx.getBean("agenceDao");
		IClientDao clientDao = (IClientDao) ctx.getBean("clientDao");
		IConseillerDao conseillerDao=(IConseillerDao) ctx.getBean("conseillerDao");
		
		Date date = new Date(42, 5, 11);
		Agence agence=new Agence(date);	
		agence.setNumero(0);
		agenceDao.ajouterAgence(agence);
		
		ConseillerClientele conseiller1=new ConseillerClientele("Duboit", "Jean","rue cul de sac" , 41000, "Cachan", 012540, agence);
		conseiller1.setAgence(agence);
		conseiller1.setId(7);
		conseillerDao.ajouterConseiller(conseiller1);
		
		Client cl1=new Client("BOULMERDJ","Nomane","VilleJuif", 94800, "VilleJuif", 00000000);
		cl1.setConseiller(conseiller1);
		cl1.setId(5);
		clientDao.ajouterClient(cl1);
		
		
		List<Client> cl = clientDao.getAllClients();
		System.out.println(cl);
	}

}