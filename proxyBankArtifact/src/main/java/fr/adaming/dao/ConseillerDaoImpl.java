package fr.adaming.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.model.Agence;
import fr.adaming.model.Client;
import fr.adaming.model.Compte;
import fr.adaming.model.ConseillerClientele;

@Repository("conseillerDao")
@Transactional
public class ConseillerDaoImpl implements IConseillerDao{

	@Autowired //injection d'une sessionFactory
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	public List<ConseillerClientele> getAllConseillers() {
		//ouvrir une session
		//Session session = sessionFactory.openSession();
		Session session=sessionFactory.getCurrentSession();
		//declaration de la requete
		String hqlReq = "from consEntity e order by e.nom asc";
		
		//envoyer la requete
		Query query = session.createQuery(hqlReq);
		
		//pagination 
		query.setFirstResult(0);//le 0 commence a partir de l'id 1
		query.setMaxResults(50);//affiche 50 resultats
		
		List<ConseillerClientele> liste = query.list();
		
		//fermer la session
		//session.close();
		
		return liste;
	}

	@Override
	public List<ConseillerClientele> getConseillersByAgence(Agence agence) {
		//ouvrir une session
				//Session session = sessionFactory.openSession();
				Session session = sessionFactory.getCurrentSession();
				//declaration de la requete
				String hqlReq = "from consEntity e where agence_id=:id1 order by e.nom asc";
				

				Query query = session.createQuery(hqlReq);
				
				query.setParameter("id1", agence.getNumero());
				
				//pagination 
				query.setFirstResult(0);//le 0 commence a partir de l'id 1
				query.setMaxResults(50);//affiche 50 resultats
				
				List<ConseillerClientele> liste = query.list();
				
				//fermer la session
				//session.close();
				
				return liste;
	}

	@Override
	public int ajouterConseiller(ConseillerClientele conseiller) {
		Session session = sessionFactory.openSession();
		//Session session = sessionFactory.getCurrentSession();
		session.save(conseiller);
		session.close();

		return 1;
	}

	@Override
	public int modifierConseiller(ConseillerClientele conseiller) {
		//Session session=sessionFactory.openSession();
		Session session = sessionFactory.getCurrentSession();
		//avec SQL natif
		String sqlreq="update conseillers set nom=:nom1, prenom=:prenom1, adresse=:adresse1, codePostal=:codePostal1,ville=:ville1, telephone=:telephone1 where id=:id1";
		SQLQuery query=session.createSQLQuery(sqlreq);
		query.addEntity(ConseillerClientele.class);//ajouter l'entité : SQL natif, par default, ne travaille pas avec les classes
		query.setParameter("nom1", conseiller.getNom());
		query.setParameter("prenom1", conseiller.getPrenom());
		query.setParameter("adresse1", conseiller.getAdresse());
		query.setParameter("codePostal1", conseiller.getCodePostal());
		query.setParameter("ville1", conseiller.getVille());
		query.setParameter("telephone1", conseiller.getTelephone());
		query.setParameter("id1", conseiller.getId());
		query.executeUpdate();
		//session.close();

		return 1;
	}

	@Override
	public int supprimerConseiller(int id) {
		//Session session = sessionFactory.openSession();
		Session session = sessionFactory.getCurrentSession();
		
		//declaration de la requete
		String hqlReq = "delete from consEntity where id=:id1";
				
		//creer la requete
		Query query = session.createQuery(hqlReq);

		//parametres de requete
	    query.setParameter("id1",id);

	    
	    //envoyer la requete
	    query.executeUpdate();
		
		//session.close();	

			return 1;
	}

	@Override
	public int supprimerConseiller(ConseillerClientele conseiller) {
//Session session = sessionFactory.openSession();
		Session session = sessionFactory.getCurrentSession();
		
		//declaration de la requete
		String hqlReq = "delete from clientEntity where nom=:nom1 and prenom=:prenom1 and adresse=:adresse1 and codePostal=:codePostal1 and ville=:ville1 and telephone=:telephone1";
				
		//creer la requete
		Query query = session.createQuery(hqlReq);

		//parametres de requete
		query.setParameter("nom1", conseiller.getNom());
		query.setParameter("prenom1", conseiller.getPrenom());
		query.setParameter("adresse1", conseiller.getAdresse());
		query.setParameter("codePostal1", conseiller.getCodePostal());
		query.setParameter("ville1", conseiller.getVille());
		query.setParameter("telephone1", conseiller.getTelephone());


	    
	    //envoyer la requete
	    query.executeUpdate();
		
		//session.close();	

			return 1;
	}

	@Override
	public ConseillerClientele getConseillerById(int id) {
		// ouvrir une session
				Session session = sessionFactory.openSession();

				// declaration de la requete
				String hqlReq = "from consEntity c where id_conmpte=:id1";

				Query query = session.createQuery(hqlReq);
				query.setParameter("id1", id);

				ConseillerClientele conseiller = (ConseillerClientele) query.uniqueResult();

				// fermer la session
				session.close();

				return conseiller;
	}

	
	
}
