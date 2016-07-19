package fr.adaming.test;
import java.util.*;

import fr.adaming.dao.*;
import fr.adaming.model.Agence;
import fr.adaming.model.Client;
import fr.adaming.model.CompteCourant;
import fr.adaming.model.CompteEpargne;
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
				ICompteDao	compteDao = (ICompteDao) ctx.getBean("compteDao");


					
					Date date = new Date(2011,11,11);
					Agence agence=new Agence(date);	
					agence.setNumero(1);
					agenceDao.ajouterAgence(agence);
				
				Date date2 = new Date(2011,11,11);
				Agence agence2=new Agence(date2);	
				agence2.setNumero(2);
				agenceDao.ajouterAgence(agence2);
				Date date3 = new Date(2002/02/02);
				agence2.setDateCreation(date3);
				agenceDao.modifierAgence(agence);
				agenceDao.supprimerAgence(agence2);
				
				Agence agence3=agenceDao.getAgenceByNumero(2);
				System.out.println(agence3);
				
				ConseillerClientele conseiller1=new ConseillerClientele("Duboit", "Jean","rue cul de sac" , 41000, "Cachan", 012540);
				conseiller1.setAgence(agence);
				conseiller1.setId(1);
				conseillerDao.ajouterConseiller(conseiller1);

				ConseillerClientele conseiller2=new ConseillerClientele("Duboit", "Jean","rue cul de sac" , 41000, "Cachan", 012540);
				conseiller2.setAgence(agence);
				conseiller2.setId(2);
				conseillerDao.ajouterConseiller(conseiller2);				
				
				conseiller2.setAdresse("nowhere");
				conseiller2.setCodePostal(10440);
				conseiller2.setNom("nom");
				conseiller2.setPrenom("prenom");
				conseillerDao.modifierConseiller(conseiller2);

				
				
				ConseillerClientele conseiller3=conseillerDao.getConseillerById(3);
				System.out.println(conseiller3);
				List<ConseillerClientele> listeCons1=conseillerDao.getAllConseillers();
				for(ConseillerClientele cons:listeCons1){
					System.out.println(cons);
				}
				
				conseillerDao.supprimerConseiller(2);
				
				List<ConseillerClientele> listeCons2=conseillerDao.getConseillersByAgence(agence);
				for(ConseillerClientele cons:listeCons2){
					System.out.println(cons);
				}
				
				Client cl1=new Client("BOULMERDJ","Nomane","VilleJuif", 94800, "VilleJuif", 00000000);
				cl1.setConseiller(conseiller3);
				cl1.setId(4);
				clientDao.ajouterClient(cl1);
				Client cl2=new Client("BOULMERDJ","Nomane","VilleJuif", 94800, "VilleJuif", 00000000);
				cl2.setConseiller(conseiller3);
				cl2.setId(5);
				clientDao.ajouterClient(cl2);
				cl2.setNom("nomClient");
				cl2.setPrenom("jack");
				clientDao.modifierClient(cl2);
				
				List<Client> listeCls1=clientDao.getAllClients();
				for(Client cls:listeCls1){
					System.out.println(cls);
				}
				
				Client cl3=clientDao.getClientById(5);
				System.out.println(cl3);
				clientDao.supprimerClient(cl3);
				
				List<Client> listeCls2=clientDao.getClientsByConseiller(conseiller3);
				for(Client cls:listeCls2){
					System.out.println(cls);
				}
//				
//				
//				CompteCourant cc1=new CompteCourant(200, date);
//				cc1.setNumero(1);
//				cc1.setClient(cl2);
//				cc1.setAutDecouvert(100);
//				System.out.println(cc1);
//				compteDao.ajouterCompteC(cc1);
//				cc1.setSolde(300);
//				cc1.setAutDecouvert(200);
//				compteDao.modifierCompteC(cc1);
//				
//				CompteEpargne ce1=new CompteEpargne(400, date2);
//				ce1.setNumero(1);
//				ce1.setClient(cl2);
//				compteDao.ajouterCompteE(ce1);
//				ce1.setSolde(500);
//				ce1.setTaux(5);
//				compteDao.modifierCompteE(ce1);
				
				
			}
}
