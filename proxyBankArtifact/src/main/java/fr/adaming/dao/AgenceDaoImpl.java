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


@Repository("agenceDao")
@Transactional
public enum AgenceDaoImpl implements IAgenceDao{
	
	@Autowired //injection d'une sessionFactory
	private SessionFactory sessionFactory;

	@Override
	public Agence getAgenceByNumero(int num) {
		//ouvrir une session
		Session session = sessionFactory.openSession();
		
		//declaration de la requete
		String hqlReq = "from agenceEntity e where numero=:id1 order by e.nom asc";
		

		Query query = session.createQuery(hqlReq);
		
		query.setParameter("id1", num);
		
		
		Agence agence=(Agence)query.uniqueResult();
		
		//fermer la session
		session.close();
		
		return agence;
	}

	@Override
	public int ajouterAgence(Agence agence) {
		Session session = sessionFactory.openSession();
		session.save(agence);
		session.close();

		return 1;
	}

	@Override
	public int modifierAgence(Agence agence) {
Session session=sessionFactory.openSession();
		
		//avec SQL natif
		String sqlreq="update agences set gerant=:gerant1 where id_agence=:id1";
		SQLQuery query=session.createSQLQuery(sqlreq);
		query.addEntity(Client.class);//ajouter l'entité : SQL natif, par default, ne travaille pas avec les classes
		query.setParameter("gerant1", agence.getGerant());
		query.setParameter("id1", agence.getNumero());

		query.executeUpdate();
		session.close();

		return 1;
	}

	@Override
	public int supprimerAgence(Agence agence) {
		Session session = sessionFactory.openSession();
		//declaration de la requete
				String hqlReq = "delete from agenceEntity where numero=:id1 ";
						
				//creer la requete
				Query query = session.createQuery(hqlReq);

				//parametres de requete
				query.setParameter("id1", agence.getNumero());

				


			    
			    //envoyer la requete
			    query.executeUpdate();
				
				session.close();	

					return 1;
	}

}
