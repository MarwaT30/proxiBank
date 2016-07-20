package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.adaming.dao.ClientDaoImpl;
import fr.adaming.dao.IClientDao;
import fr.adaming.dao.ICompteDao;
import fr.adaming.dao.IConseillerDao;
import fr.adaming.exception.ExceptionNombreClient;
import fr.adaming.exception.ExceptionSolde;
import fr.adaming.model.Client;
import fr.adaming.model.CompteCourant;
import fr.adaming.model.CompteEpargne;
import fr.adaming.model.ConseillerClientele;

@Service("clientServiceBean")
public class ClientServiceImpl implements IClientService {
	@Autowired
	private IClientDao clientDao;
	
	@Autowired
	private IConseillerDao conseillerDao;
	
	@Autowired
	private ICompteService compteService;


	@Autowired
	private ICompteDao compteDao;



	/**
	 * @param clientDao the clientDao to set
	 */
	public void setClientDao(IClientDao clientDao) {
		this.clientDao = clientDao;
	}

	@Override
	public List<Client> getAllClients() {
		return clientDao.getAllClients();
	}

	@Override
	public List<Client> getClientsByConseiller(ConseillerClientele conseiller) {
		return clientDao.getClientsByConseiller(conseiller);
	}

	
	//public void ajouterClient(Client client) throws ExceptionNombreClient{
		
		//ConseillerClientele conseiller= client.getConseiller();
		//List<Client> clients=conseiller.getClients();
//		if(	clients.size()>9) {
//		throw new ExceptionNombreClient("le Nombre de Clients est superieur à 10");
//		}else{
//		
		//clientDao.ajouterClient(client);
		//}
//	}

	public void ajouterClient(int idConseiller,Client client,CompteCourant compteCourant, CompteEpargne compteEpargne) throws ExceptionNombreClient{

		ConseillerClientele conseiller= conseillerDao.getConseillerById(idConseiller);
		List<Client> clients=conseiller.getClients();


		if(	clients.size()>9) {
			throw new ExceptionNombreClient("le Nombre de Clients est superieur à 10");
		}else{
			client.setConseiller(conseiller);
			clients.add(client);
			conseiller.setClients(clients);

			if (compteCourant!=null){
				CompteCourant compteCourants=client.getCompteCourant();
				client.setCompteCourant(compteCourants);
				compteCourant.setClient(client);
			}

			if (compteEpargne!=null){
				CompteEpargne compteEpargnes=client.getCompteEpargne();
				client.setCompteEpargne(compteEpargnes);
				compteEpargne.setClient(client);

			}


			conseillerDao.modifierConseiller(conseiller);
			clientDao.ajouterClient(client);
			if (compteCourant!=null){
				compteDao.ajouterCompteC(compteCourant);
			}

			if (compteEpargne!=null){
				compteDao.ajouterCompteE(compteEpargne);
			}

		}


}
	
	
	@Override
	public void modifierClient(Client client) {
		clientDao.modifierClient(client);
	}

	@Override
	public void supprimerClient(int id) {
		clientDao.supprimerClient(id);
		
	}

	@Override
	public void supprimerClient(Client client) {
		clientDao.supprimerClient(client);
	}
	
	public void virement(float solde, int idComptecourant1,
						int idCompteEpargne1, int idComptecourant2,
						int idCompteEpargne2) throws ExceptionSolde {
			
					if (idComptecourant1 != 0 && idCompteEpargne1 ==0 ){ 
						CompteCourant compte1 = (CompteCourant) compteDao.getCompteCourantByNumero(idComptecourant1);
						compte1.setSolde(solde);
						compteService.modifierCompteC(compte1);
			
						if (idComptecourant2 != 0 ){ 
							CompteCourant compte2 = (CompteCourant) compteDao.getCompteCourantByNumero(idComptecourant2);
							compte2.setSolde(solde);
							compteService.modifierCompteC(compte2);

						}
						else { 
							CompteEpargne compte2 = (CompteEpargne) compteDao.getCompteCourantByNumero(idCompteEpargne2);
							compte2.setSolde(solde);
							compteService.modifierCompteE(compte2);
							compteService.addMoney(solde, idCompteEpargne2);
					}
					else {
			
						compteService.TakeMoney(solde, idCompteEpargne1);
			
						if (idComptecourant2 != 0 ){ 
			
							compteService.addMoney(solde, idComptecourant2);
			
						}
						else { 
			
							compteService.addMoney(solde, idCompteEpargne2);
						}
			
				}
				}

}
