package fr.adaming.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.model.CarteBancaire;

import fr.adaming.model.Compte;
import fr.adaming.model.CompteCourant;
@Repository
@Transactional
public class CarteDaoImpl implements ICarteDao {

	@Autowired //injection d'une sessionFactory
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public CarteBancaire getCarteByCompte(CompteCourant compte) {
		Session session = sessionFactory.getCurrentSession();	
		return compte.getCarte();
	}

	@Override
	public Compte getCompteByCarte(CarteBancaire carte) {
		Session session = sessionFactory.getCurrentSession();
		return carte.getCompte();
	}

	@Override
	public int ajouterCarte(CarteBancaire carte) {
		Session session = sessionFactory.getCurrentSession();
		session.save(carte);
		return 1;
	}

	@Override
	public int modifierCarte(CarteBancaire carte) {
		Session session = sessionFactory.getCurrentSession();
		session.update(carte);
		return 1;
	}

	@Override
	public int supprimerCarte(CarteBancaire carte) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(carte);
		return 0;
	}	

}
