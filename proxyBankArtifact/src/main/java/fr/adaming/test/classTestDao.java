package fr.adaming.test;
import java.sql.Date;


import fr.adaming.dao.*;
import fr.adaming.model.Agence;
import fr.adaming.model.Client;
import fr.adaming.model.ConseillerClientele;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class classTestDao {
	public static void main(String[] args) {
				ApplicationContext ctx = new FileSystemXmlApplicationContext("src/main/webapp/WEB-INF/applicationContext.xml");
				
				IAgenceDao agenceDao = (IAgenceDao) ctx.getBean("agenceDao");
				IClientDao clientDao = (IClientDao) ctx.getBean("clientDao");
				IConseillerDao conseillerDao=(IConseillerDao) ctx.getBean("conseillerDao");
		
				
////				Agence agence=agenceDao.getAgenceByNumero(1);
////				System.out.println(agence);
//				Date date = new Date(2011,11,11);
//				Agence agence=new Agence(date);
//				//agenceDao.ajouterAgence(agence);
//				
//				ConseillerClientele conseiller1=new ConseillerClientele("Duboit", "Jean","rue cul de sac" , 41000, "Cachan", 012540, agence);
//				conseillerDao.ajouterConseiller(conseiller1);
//				
//				
//				
//				Client cl1=new Client("BOULMERDJ","Nomane","VilleJuif", 94800, "VilleJuif", 00000000);
//				cl1.setConseiller(conseiller1);
//				clientDao.ajouterClient(cl1);
		
			}
}
