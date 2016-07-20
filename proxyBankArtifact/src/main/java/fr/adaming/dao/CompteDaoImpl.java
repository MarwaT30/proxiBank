package fr.adaming.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.model.Client;
import fr.adaming.model.Compte;
import fr.adaming.model.CompteCourant;
import fr.adaming.model.CompteEpargne;

@Repository("compteDao")
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
	public Compte getCompteCourantByNumero(int numero) {
		// ouvrir une session
		Session session = sessionFactory.getCurrentSession();

		// declaration de la requete
		String hqlReq = "from compteCourantEntity c where id_conmpte=:id1";

		Query query = session.createQuery(hqlReq);
		query.setParameter("id1", numero);

		CompteCourant compte = (CompteCourant) query.uniqueResult();

		// fermer la session
		// session.close();

		return compte;
	}

	@Override
	public Compte getCompteEpargneByNumero(int numero) {
		// ouvrir une session
		Session session = sessionFactory.getCurrentSession();

		// declaration de la requete
		String hqlReq = "from compteEpargneEntity c where id_conmpte=:id1";

		Query query = session.createQuery(hqlReq);
		query.setParameter("id1", numero);

		CompteEpargne compte = (CompteEpargne) query.uniqueResult();

		// fermer la session
		// session.close();

		return compte;
	}

	@Override
	public CompteCourant getCompteCourantByClient(Client client) {
		// ouvrir une session
		Session session = sessionFactory.getCurrentSession();

		// declaration de la requete
		String hqlReq = "from compteCourantEntity c where id_client=:id1";

		Query query = session.createQuery(hqlReq);
		query.setParameter("id1", client.getId());

		CompteCourant compte = (CompteCourant) query.uniqueResult();

		// fermer la session
		// session.close();

		return compte;
	}

	@Override
	public CompteEpargne getEpargneByClient(Client client) {
		Session session = sessionFactory.getCurrentSession();

		// declaration de la requete
		String hqlReq = "from compteEpargneEntity c where id_client=:id1";

		Query query = session.createQuery(hqlReq);
		query.setParameter("id1", client.getId());

		CompteEpargne compte = (CompteEpargne) query.uniqueResult();


		return compte;
	}

	@Override
	public int ajouterCompteC(CompteCourant compteC) {
		Session session = sessionFactory.getCurrentSession();
		session.save(compteC);

		return 1;
	}

	@Override
	public int modifierCompteC(CompteCourant compteC) {
		Session session = sessionFactory.getCurrentSession();
		CompteCourant compteC1=(CompteCourant)session.get(CompteCourant.class, compteC.getNumero());
		session.update(compteC1);
		
		return 1;
	}

	@Override
	public int supprimerCompteC(CompteCourant compteC) {
		Session session = sessionFactory.getCurrentSession();
		CompteCourant compteC1=(CompteCourant)session.get(CompteCourant.class, compteC.getNumero());
		session.delete(compteC1);
		return 1;
	}

	@Override
	public int ajouterCompteE(CompteEpargne compteE) {
		Session session = sessionFactory.getCurrentSession();
		session.save(compteE);
		return 1;
	}

	@Override
	public int modifierCompteE(CompteEpargne compteE) {
		Session session = sessionFactory.getCurrentSession();
		CompteEpargne compteE1=(CompteEpargne)session.get(CompteEpargne.class, compteE.getNumero());
		session.update(compteE1);
		return 1;
	}

	@Override
	public int supprimerCompteE(CompteEpargne compteE) {
		Session session = sessionFactory.getCurrentSession();
		CompteEpargne compteE1=(CompteEpargne)session.get(CompteEpargne.class, compteE.getNumero());
		session.delete(compteE1);
		return 1;
	}

}
