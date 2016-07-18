package fr.adaming.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.model.CarteBancaire;
import fr.adaming.model.CarteElectron;
import fr.adaming.model.CartePremier;
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
	public CarteBancaire getCarteElectronByCompte(CompteCourant compte) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CarteBancaire getCartePremiumByCompte(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Compte getCompteByCarteElectron(CarteBancaire carte) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Compte getCompteByCartePremium(CarteBancaire carte) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int ajouterCarteElectron(CarteElectron carte) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int ajouterCartePremium(CartePremier carte) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int modifierCarte(CarteBancaire carte) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int supprimerCarte(CarteBancaire carte) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	

}
