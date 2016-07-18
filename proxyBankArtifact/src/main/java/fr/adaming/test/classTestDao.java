package fr.adaming.test;
import java.sql.Date;
import java.util.*;

import fr.adaming.dao.*;
import fr.adaming.model.Agence;
import fr.adaming.model.Client;
import fr.adaming.model.CompteCourant;
import fr.adaming.model.ConseillerClientele;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class classTestDao {
	public static void main(String[] args) {
				ApplicationContext ctx = new FileSystemXmlApplicationContext("src/main/webapp/WEB-INF/applicationContext.xml");
				IGerantDao gerantDao = (IGerantDao) ctx.getBean("gerantDao");
				IAgenceDao agenceDao = (IAgenceDao) ctx.getBean("agenceDao");
				IClientDao clientDao = (IClientDao) ctx.getBean("clientDao");
				IConseillerDao conseillerDao=(IConseillerDao) ctx.getBean("conseillerDao");
					ICompteDao	


				Date date = new Date(2011,11,11);
				Agence agence=new Agence(date);	
				agence.setNumero(1);
				agenceDao.ajouterAgence(agence);
				
				Date date2 = new Date(2011,11,11);
				Agence agence2=new Agence(date2);	
				agence2.setNumero(1);
				agenceDao.ajouterAgence(agence2);
				Date date3 = new Date(2002/02/02);
				agence2.setDateCreation(date3);
				agenceDao.modifierAgence(agence);
				agenceDao.supprimerAgence(agence2);
				
				Agence agence3=agenceDao.getAgenceByNumero(2);
				
				ConseillerClientele conseiller1=new ConseillerClientele("Duboit", "Jean","rue cul de sac" , 41000, "Cachan", 012540);
	//			ConseillerClientele conseiller1=new ConseillerClientele("Duboit", "Jean","rue cul de sac" , 41000, "Cachan", 012540, agence);
				conseiller1.setAgence(agence);
				conseiller1.setId(1);
				conseillerDao.ajouterConseiller(conseiller1);
<<<<<<< HEAD
				ConseillerClientele conseiller2=new ConseillerClientele("Duboit", "Jean","rue cul de sac" , 41000, "Cachan", 012540);
				conseiller2.setAgence(agence3);
				conseiller2.setId(2);
				conseiller2.setAdresse("nowhere");
				conseiller2.setCodePostal(10440);
				conseiller2.setNom("nom");
				conseiller2.setPrenom("prenom");
				conseillerDao.modifierConseiller(conseiller2);
				
				ConseillerClientele conseiller3=conseillerDao.getConseillerById(1);
				List<ConseillerClientele> listeCons1=conseillerDao.getAllConseillers();
				for(ConseillerClientele cons:listeCons1){
					System.out.println(cons);
				}
				
				conseillerDao.supprimerConseiller(1);
				
				List<ConseillerClientele> listeCons2=conseillerDao.getConseillersByAgence(agence3);
				for(ConseillerClientele cons:listeCons2){
					System.out.println(cons);
				}
				
				
				
=======
//				
//				
//				
>>>>>>> refs/remotes/origin/master
				Client cl1=new Client("BOULMERDJ","Nomane","VilleJuif", 94800, "VilleJuif", 00000000);
				cl1.setConseiller(conseiller2);
				cl1.setId(1);
				clientDao.ajouterClient(cl1);
				Client cl2=new Client("BOULMERDJ","Nomane","VilleJuif", 94800, "VilleJuif", 00000000);
				cl2.setConseiller(conseiller2);
				cl2.setId(2);
				clientDao.ajouterClient(cl2);
				cl2.setNom("nomClient");
				cl2.setPrenom("jack");
				clientDao.modifierClient(cl2);
				
				List<Client> listeCls1=clientDao.getAllClients();
				for(Client cls:listeCls1){
					System.out.println(cls);
				}
				
				Client cl3=clientDao.getClientById(1);
				clientDao.supprimerClient(cl3);
				
				List<Client> listeCls2=clientDao.getClientsByConseiller(conseiller2);
				for(Client cls:listeCls2){
					System.out.println(cls);
				}
				
				
				CompteCourant cc1=new CompteCourant(200, date);
				cc1.setNumero(1);
				
		
			}
}
