package fr.adaming.dao;

import java.util.List;

import fr.adaming.model.Agence;
import fr.adaming.model.Client;
import fr.adaming.model.ConseillerClientele;

public interface IConseillerDao {

	/**
	 * 
	 * @return
	 */
	public List<ConseillerClientele> getAllConseillers();

/**
 * 
 * @param agence
 * @return liste des conseillers clientèle de l'agence
 */
	public List<ConseillerClientele> getConseillersByAgence(Agence agence);

	/**
	 * ajouter un conseiller dans la BD
	 * @param conseiller
	 * @return 1 si OK
	 */
	public int ajouterConseiller(ConseillerClientele conseiller);

	/**
	 * modifier un conseiller de la BD
	 * @param conseiller
	 * @return 1 si OK
	 */
	public int modifierConseiller(ConseillerClientele conseiller);

	/**
	 * supprimer le conseiller de la BD
	 * @param id
	 * @return 1 si OK
	 */
	public int supprimerConseiller(int id);

	/**
	 * supprimer le conseiller de la BD
	 * @param conseiller
	 * @return 1 si OK
	 */
	public int supprimerConseiller(ConseillerClientele conseiller);
	
	/**
	 * find object type ConseillerClientele with object id
	 * @param id
	 * @return object type ConseillerClientele
	 */
	public ConseillerClientele getConseillerById(int id);
	
	/**
	 * 
	 * @param nom
	 * @param prenom
	 * @return
	 */
	public int isExist(String nom,String prenom);
}
