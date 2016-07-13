import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.adaming.dao.ICarteDao;
import fr.adaming.dao.IClientDao;
import fr.adaming.dao.ICompteDao;
import fr.adaming.dao.IConseillerDao;
import fr.adaming.model.CarteBancaire;
import fr.adaming.model.CarteElectron;
import fr.adaming.model.Client;
import fr.adaming.model.Compte;
import fr.adaming.model.CompteCourant;
import fr.adaming.model.CompteEpargne;
import fr.adaming.model.ConseillerClientele;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/applicationContext.xml"})
public class TestCreerClasses {
	@Autowired
	IClientDao clientDao;
	
	@Autowired
	ICarteDao carteDao;
	
	@Autowired
	ICompteDao compteDao;
	
	@Autowired
	IConseillerDao conseillerDao;
	
	@Test
	public void ajouterTest(){
		
		ConseillerClientele conseiller=new ConseillerClientele("MORMONT", "Lyanna", "ile aux ours", 666, 1234);
		Client client1=new Client("CASSEL", "Jorris","pont d'avignon", 42100,01234567);
		Client client2=new Client("SCHELTENS","Guillaume","chantier naval",42100,01224);
		
		CompteCourant comptec=new CompteCourant(100);
		CompteEpargne comptee=new CompteEpargne((float)4.8);
		
		CarteElectron cartee=new CarteElectron();


	}

}
