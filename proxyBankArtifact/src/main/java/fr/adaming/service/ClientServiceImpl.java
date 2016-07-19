package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.adaming.dao.ClientDaoImpl;
import fr.adaming.dao.IClientDao;
import fr.adaming.dao.IConseillerDao;
import fr.adaming.exception.ExceptionNombreClient;
import fr.adaming.model.Client;
import fr.adaming.model.CompteCourant;
import fr.adaming.model.CompteEpargne;
import fr.adaming.model.ConseillerClientele;

@Service("clientServiceBean")
public class ClientServiceImpl implements IClientService {
	@Autowired
	IClientDao clientDao;
	
	@Autowired
	IConseillerDao conseillerDao;
	
	@Autowired
	ICompteService compteDao;



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

}
