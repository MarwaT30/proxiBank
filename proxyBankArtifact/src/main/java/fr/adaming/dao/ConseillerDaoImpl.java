package fr.adaming.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.model.Agence;
import fr.adaming.model.Client;
import fr.adaming.model.ConseillerClientele;

@Repository("conseillerDao")
@Transactional
public class ConseillerDaoImpl implements IConseillerDao{

	@Autowired //injection d'une sessionFactory
	private SessionFactory sessionFactory;
	
	@Override
	public List<Client> getAllConseillers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Client> getConseillersByAgence(Agence agence) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int ajouterConseiller(ConseillerClientele conseiller) {
		Session session = sessionFactory.openSession();
		session.save(conseiller);
		session.close();

		return 1;
	}

	@Override
	public int modifierConseiller(ConseillerClientele conseiller) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int supprimerConseiller(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int supprimerConseiller(ConseillerClientele conseiller) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	
}
