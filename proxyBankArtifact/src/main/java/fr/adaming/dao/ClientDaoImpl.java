package fr.adaming.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.model.Client;
import fr.adaming.model.ConseillerClientele;
@Repository
@Transactional

public class ClientDaoImpl implements IClientDao{
	@Autowired //injection d'une sessionFactory
	private SessionFactory sessionFactory;

	@Override
	public List<Client> getAllClients() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Client> getClientsByConseiller(ConseillerClientele conseiller) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int ajouterClient(Client client) {
		
		Session session = sessionFactory.openSession();
		session.save(client);
		session.close();

		return 1;
	}

	@Override
	public int modifierClient(Client client) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int supprimerClient(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int supprimerClient(Client client) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	
}
