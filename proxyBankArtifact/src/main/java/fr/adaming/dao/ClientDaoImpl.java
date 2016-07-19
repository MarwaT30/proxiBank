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
import fr.adaming.model.ConseillerClientele;

@Repository("clientDao")
@Transactional
public class ClientDaoImpl implements IClientDao {
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
	public List<Client> getAllClients() {
		// ouvrir une session
		Session session = sessionFactory.getCurrentSession();

		// declaration de la requete
		String hqlReq = "from clientEntity e order by e.nom asc";

		// envoyer la requete
		Query query = session.createQuery(hqlReq);

		List<Client> liste = query.list();

		// fermer la session
		// session.close();

		return liste;
	}

	@Override
	public List<Client> getClientsByConseiller(ConseillerClientele conseiller) {
		// ouvrir une session
		Session session = sessionFactory.getCurrentSession();

		// declaration de la requete
		String hqlReq = "from clientEntity e where Id_Conseiller=:id1 order by e.nom asc";

		Query query = session.createQuery(hqlReq);

		query.setParameter("id1", conseiller.getId());

		List<Client> liste = query.list();

		// fermer la session
		// session.close();

		return liste;
	}

	@Override
	public int ajouterClient(Client client) {

		Session session = sessionFactory.getCurrentSession();
		session.save(client);
		//session.close();

		return 1;
	}

	@Override
	public int modifierClient(Client client) {
		Session session = sessionFactory.getCurrentSession();
		session.update(client);
		// avec SQL natif
//		String sqlreq = "update clients set nom=:nom1, prenom=:prenom1, adresse=:adresse1, code_postal=:codePostal1, ville=:ville1, telephone=:telephone1  where id=:id1";
//		SQLQuery query = session.createSQLQuery(sqlreq);
//		// ajouter l'entité : SQL natif, par default, ne travaille pas avec les classes
//		query.addEntity(Client.class);
//
//		query.setParameter("nom1", client.getNom());
//		query.setParameter("prenom1", client.getPrenom());
//		query.setParameter("adresse1", client.getAdresse());
//		query.setParameter("codePostal1", client.getCodePostal());
//		query.setParameter("ville1", client.getVille());
//		query.setParameter("telephone1", client.getTelephone());
//		query.setParameter("id2", client.getConseiller().getId());
//		query.setParameter("id1", client.getId());
		//query.executeUpdate();
		// session.close();
		//return query.executeUpdate();
		return 1;
	}

	@Override
	public int supprimerClient(int id) {
		Session session = sessionFactory.getCurrentSession();

		// declaration de la requete
		String hqlReq = "delete from clientEntity where id=:id1";

		// creer la requete
		Query query = session.createQuery(hqlReq);

		// parametres de requete
		query.setParameter("id1", id);

		// envoyer la requete
		
		// session.close();
		return query.executeUpdate();
	}

	@Override
	public int supprimerClient(Client client) {
		Session session = sessionFactory.getCurrentSession();

		// declaration de la requete
		String hqlReq = "delete from clientEntity where nom=:nom1 and prenom=:prenom1 and adresse=:adresse1 and codePostal=:codePostal1 and ville=:ville1 and telephone=:telephone1";

		// creer la requete
		Query query = session.createQuery(hqlReq);

		// parametres de requete
		query.setParameter("nom1", client.getNom());
		query.setParameter("prenom1", client.getPrenom());
		query.setParameter("adresse1", client.getAdresse());
		query.setParameter("codePostal1", client.getCodePostal());
		query.setParameter("ville1", client.getVille());
		query.setParameter("telephone1", client.getTelephone());

		// envoyer la requete
		
		// session.close();
		return query.executeUpdate();
	}

	@Override
	public Client getClientById(int id) {
		// ouvrir une session
		Session session = sessionFactory.openSession();

		// declaration de la requete
		String hqlReq = "from clientEntity c where id=:id1";

		Query query = session.createQuery(hqlReq);
		query.setParameter("id1", id);

		Client client = (Client) query.uniqueResult();

		// fermer la session
		session.close();

		return client;
	}

}
