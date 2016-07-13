package fr.adaming.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.model.Compte;

@Repository
@Transactional
public class CompteDaoImpl implements ICompteDao{
	@Autowired //injection d'une sessionFactory
	private SessionFactory sessionFactory;
	
	@Override
	public Compte getCompteByNumero(int numero) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int ajouterCompte(Compte compte) {
		Session session = sessionFactory.openSession();
		session.save(compte);
		session.close();

		return 1;
	}

	@Override
	public int modifierCompte(Compte compte) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int supprimercompte(Compte compte) {
		// TODO Auto-generated method stub
		return 0;
	}

}
