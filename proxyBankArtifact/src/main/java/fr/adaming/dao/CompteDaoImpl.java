package fr.adaming.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.model.Client;
import fr.adaming.model.Compte;

@Repository
@Transactional
public class CompteDaoImpl implements ICompteDao {
	@Autowired
	// injection d'une sessionFactory
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
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
	public int supprimerCompte(Compte compte) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Compte getCompteCourantByNumero(int numero) {
		// ouvrir une session
		Session session = sessionFactory.openSession();

		// declaration de la requete
		String hqlReq = "from compteCourantEntity c where id_conmpte=:id1";

		Query query = session.createQuery(hqlReq);
		query.setParameter("id1", numero);

		Compte compte = (Compte) query.uniqueResult();

		// fermer la session
		session.close();

		return compte;
	}

	@Override
	public Compte getCompteEpargneByNumero(int numero) {
		// ouvrir une session
		Session session = sessionFactory.openSession();

		// declaration de la requete
		String hqlReq = "from compteEpargneEntity c where id_conmpte=:id1";

		Query query = session.createQuery(hqlReq);
		query.setParameter("id1", numero);

		Compte compte = (Compte) query.uniqueResult();

		// fermer la session
		session.close();

		return compte;
	}

}
