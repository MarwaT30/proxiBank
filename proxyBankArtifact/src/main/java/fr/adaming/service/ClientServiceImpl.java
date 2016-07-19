package fr.adaming.service;

import java.util.List;

import fr.adaming.dao.ClientDaoImpl;
import fr.adaming.dao.IClientDao;
import fr.adaming.exception.ExceptionNombreClient;
import fr.adaming.model.Client;
import fr.adaming.model.ConseillerClientele;

public class ClientServiceImpl implements IClientService {
	IClientDao clientDao = new ClientDaoImpl();

	@Override
	public List<Client> getAllClients() {
		return clientDao.getAllClients();
	}

	@Override
	public List<Client> getClientsByConseiller(ConseillerClientele conseiller) {
		return clientDao.getClientsByConseiller(conseiller);
	}

	
	public void ajouterClient(Client client) throws ExceptionNombreClient{
		
		ConseillerClientele conseiller= client.getConseiller();
		List<Client> clients=conseiller.getClients();
		if(	clients.size()>9) {
		throw new ExceptionNombreClient("le Nombre de Clients est superieur à 10");
		}else{
		
		clientDao.ajouterClient(client);
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
