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
		Session session = sessionFactory.openSession();

		// declaration de la requete
		String hqlReq = "from compteCourantEntity c where id_conmpte=:id1";

		Query query = session.createQuery(hqlReq);
		query.setParameter("id1", numero);

		CompteCourant compte = (CompteCourant) query.uniqueResult();

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

		CompteEpargne compte = (CompteEpargne) query.uniqueResult();

		// fermer la session
		session.close();

		return compte;
	}

	@Override
	public List<CompteCourant> getCompteCourantByClient(Client client) {
		// ouvrir une session
				Session session = sessionFactory.openSession();

				// declaration de la requete
				String hqlReq = "from compteCourantEntity c where id_client=:id1";

				Query query = session.createQuery(hqlReq);
				query.setParameter("id1", client.getId());

				List<CompteCourant> liste= (List<CompteCourant>)query.list();

				// fermer la session
				session.close();

				return liste;
	}

	@Override
	public List<CompteEpargne> getEpargneByClient(Client client) {
		Session session = sessionFactory.openSession();

		// declaration de la requete
		String hqlReq = "from compteEpargneEntity c where id_client=:id1";

		Query query = session.createQuery(hqlReq);
		query.setParameter("id1", client.getId());

		List<CompteEpargne> liste= (List<CompteEpargne>)query.list();

		// fermer la session
		session.close();

		return liste;
	}

	@Override
	public int ajouterCompteC(CompteCourant compteC) {
		Session session = sessionFactory.getCurrentSession();
		session.save(compteC);
		//session.close();

		return 1;
	}

	@Override
	public int modifierCompteC(CompteCourant compteC) {
		Session session = sessionFactory.getCurrentSession();
			session.update(compteC);
//		// avec SQL natif
//		String sqlreq = "update comptes_courants set date_ouverture=:date1 , solde=:solde1, aut_decouvert:=dec1 where id=:id1";
//		SQLQuery query = session.createSQLQuery(sqlreq);
//		// ajouter l'entité : SQL natif, par default, ne travaille pas avec les classes
//		query.addEntity(CompteCourant.class);
//		query.setParameter("date1", compteC.getDateOuverture());
//		query.setParameter("solde1", compteC.getSolde());
//		query.setParameter("dec1", compteC.getAutDecouvert());
//		query.setParameter("id1", compteC.getNumero());
		// query.executeUpdate();
		// session.close();
		//return query.executeUpdate();
			return 1;
	}

	@Override
	public int supprimerCompteC(CompteCourant compteC) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(compteC);
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

		// avec SQL natif
		String sqlreq = "update comptes_epargnes set date_ouverture=:date1 , solde=:solde1, taux:=dec1 where id=:id1";
		SQLQuery query = session.createSQLQuery(sqlreq);
		// ajouter l'entité : SQL natif, par default, ne travaille pas avec les classes
		query.addEntity(CompteEpargne.class);
		query.setParameter("date1", compteE.getDateOuverture());
		query.setParameter("solde1", compteE.getSolde());
		query.setParameter("dec1", compteE.getTaux());
		query.setParameter("id1", compteE.getNumero());
		// query.executeUpdate();
		// session.close();
		return query.executeUpdate();
	}

	@Override
	public int supprimerCompteE(CompteEpargne compteE) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(compteE);
		return 1;
	}

}
