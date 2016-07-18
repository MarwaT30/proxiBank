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
import fr.adaming.model.ConseillerClientele;
import fr.adaming.model.Gerant;

@Repository("gerantDao")
@Transactional
public class GerantDaoImpl implements IGerantDao{
	@Autowired //injection d'une sessionFactory
	private SessionFactory sessionFactory;
	@Override
	public List<Gerant> getAllGerants() {
		//ouvrir une session
				Session session = sessionFactory.openSession();
				
				//declaration de la requete
				String hqlReq = "from gerantEntity e order by e.nom asc";
				
				//envoyer la requete
				Query query = session.createQuery(hqlReq);
				
				//pagination 
				query.setFirstResult(0);//le 0 commence a partir de l'id 1
				query.setMaxResults(50);//affiche 50 resultats
				
				List<Gerant> liste = query.list();
				
				//fermer la session
				session.close();
				
				return liste;
	}

	@Override
	public List<Gerant> getGerantsByAgence(Agence agence) {
		//ouvrir une session
		Session session = sessionFactory.openSession();
		
		//declaration de la requete
		String hqlReq = "from gerantEntity e where agence_id=:id1 order by e.nom asc";
		

		Query query = session.createQuery(hqlReq);
		
		query.setParameter("id1", agence.getNumero());
		
		//pagination 
		query.setFirstResult(0);//le 0 commence a partir de l'id 1
		query.setMaxResults(50);//affiche 50 resultats
		
		List<Gerant> liste = query.list();
		
		//fermer la session
		session.close();
		
		return liste;
	}

	@Override
	public int ajouterGerant(Gerant gerant) {
		Session session = sessionFactory.openSession();
		session.save(gerant);
		session.close();

		return 1;
	}

	@Override
	public int modifierGerant(Gerant gerant) {
Session session=sessionFactory.openSession();
		
		//avec SQL natif
		String sqlreq="update conseillers set nom=:nom1, prenom=:prenom1, adresse=:adresse1, codePostal=:codePostal1,ville=:ville1, telephone=:telephone1 where id=:id1";
		SQLQuery query=session.createSQLQuery(sqlreq);
		query.addEntity(Client.class);//ajouter l'entité : SQL natif, par default, ne travaille pas avec les classes
		query.setParameter("nom1", gerant.getNom());
		query.setParameter("prenom1", gerant.getPrenom());
		query.setParameter("adresse1", gerant.getAdresse());
		query.setParameter("codePostal1", gerant.getCodePostal());
		query.setParameter("ville1", gerant.getVille());
		query.setParameter("telephone1", gerant.getTelephone());
		query.setParameter("id1",gerant.getId());
		query.executeUpdate();
		session.close();
		
		return 1;
	}

	@Override
	public int supprimerGerant(int id) {
Session session = sessionFactory.openSession();

		
		//declaration de la requete
		String hqlReq = "delete from consEntity where id=:id1";
				
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
	public int supprimerGerant(Gerant gerant) {
Session session = sessionFactory.openSession();

		
		//declaration de la requete
		String hqlReq = "delete from clientEntity where nom=:nom1 and prenom=:prenom1 and adresse=:adresse1 and codePostal=:codePostal1 and ville=:ville1 and telephone=:telephone1";
				
		//creer la requete
		Query query = session.createQuery(hqlReq);

		//parametres de requete
		query.setParameter("nom1", gerant.getNom());
		query.setParameter("prenom1", gerant.getPrenom());
		query.setParameter("adresse1", gerant.getAdresse());
		query.setParameter("codePostal1", gerant.getCodePostal());
		query.setParameter("ville1", gerant.getVille());
		query.setParameter("telephone1", gerant.getTelephone());


	    
	    //envoyer la requete
	    query.executeUpdate();
		
		session.close();	

			return 1;
	}

	
	
}
