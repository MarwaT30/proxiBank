package fr.adaming.service;

import java.util.List;

import fr.adaming.dao.ClientDaoImpl;
import fr.adaming.dao.IClientDao;
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

	@Override
	public int ajouterClient(Client client) {
		return clientDao.ajouterClient(client);
	}

	@Override
	public int modifierClient(Client client) {
		return clientDao.modifierClient(client);
	}

	@Override
	public int supprimerClient(int id) {
		return clientDao.supprimerClient(id);
		// TODO supprimer comptes associes
	}

	@Override
	public int supprimerClient(Client client) {
		return clientDao.supprimerClient(client);
	}

}
