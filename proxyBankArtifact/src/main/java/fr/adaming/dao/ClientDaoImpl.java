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
@Repository
@Transactional

public class ClientDaoImpl implements IClientDao{
	@Autowired //injection d'une sessionFactory
	private SessionFactory sessionFactory;

	@Override
	public List<Client> getAllClients() {
		//ouvrir une session
				Session session = sessionFactory.openSession();
				
				//declaration de la requete
				String hqlReq = "from EmpEntity e order by e.nom asc";
				
				//envoyer la requete
				Query query = session.createQuery(hqlReq);
				
				//pagination 
				query.setFirstResult(0);//le 0 commence a partir de l'id 1
				query.setMaxResults(50);//affiche 50 resultats
				
				List<Client> liste = query.list();
				
				//fermer la session
				session.close();
				
				return liste;

	}

	@Override
	public List<Client> getClientsByConseiller(ConseillerClientele conseiller) {
		//ouvrir une session
		Session session = sessionFactory.openSession();
		
		//declaration de la requete
		String hqlReq = "from EmpEntity e where id_conseiller=:id1 order by e.nom asc";
		

		Query query = session.createQuery(hqlReq);
		
		query.setParameter("id1", conseiller.getId());
		
		//pagination 
		query.setFirstResult(0);//le 0 commence a partir de l'id 1
		query.setMaxResults(50);//affiche 50 resultats
		
		List<Client> liste = query.list();
		
		//fermer la session
		session.close();
		
		return liste;
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
		Session session=sessionFactory.openSession();
		
		//avec SQL natif
		String sqlreq="update employes set nom=:nom1, prenom=:prenom1, adresse=:adresse1, codePostal=:codePostal1, telephone=:telephone1 where id=:id1";
		SQLQuery query=session.createSQLQuery(sqlreq);
		query.addEntity(Client.class);//ajouter l'entité : SQL natif, par default, ne travaille pas avec les classes
		query.setParameter("nom1", client.getNom());
		query.setParameter("prenom1", client.getPrenom());
		query.setParameter("adresse1", client.getAdresse());
		query.setParameter("codePostal", client.getCodePostal());
		query.setParameter("telephone1", client.getTelephone());
		query.setParameter("id1", client.getId());
		query.executeUpdate();
		session.close();

		return 1;
	}

	@Override
	public int supprimerClient(int id) {
	Session session = sessionFactory.openSession();

	
	//declaration de la requete
	String hqlReq = "delete from EmpEntity where id=:id1";
			
	//creer la requete
	Query query = session.createQuery(hqlReq);

	//parametres de requete
    query.setParameter("id1",id);

    
    //envoyer la requete
    query.executeUpdate();
	
	session.close();	

		return 1;
	}

	@Override
	public int supprimerClient(Client client) {
		Session session = sessionFactory.openSession();

		
		//declaration de la requete
		String hqlReq = "delete from EmpEntity where nom=:nom1 and prenom=:prenom1 and adresse=:adresse1 and codePostal=:codePostal1 and telephone=:telephone1";
				
		//creer la requete
		Query query = session.createQuery(hqlReq);

		//parametres de requete
		query.setParameter("nom1", client.getNom());
		query.setParameter("prenom1", client.getPrenom());
		query.setParameter("adresse1", client.getAdresse());
		query.setParameter("codePostal", client.getCodePostal());
		query.setParameter("telephone1", client.getTelephone());
		query.setParameter("id1", client.getId());

	    
	    //envoyer la requete
	    query.executeUpdate();
		
		session.close();	

			return 1;

	}

	
	
}
