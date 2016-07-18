package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Agence;
import fr.adaming.model.Gerant;

public interface IGerantService {
	/**
	 * 
	 * @return
	 */
	public List<Gerant> getAllGerants();

	/**
	 * 
	 * @param agence
	 * @return liste des conseillers clientèle de l'agence
	 */
	public List<Gerant> getGerantsByAgence(Agence agence);

	/**
	 * ajouter un conseiller dans la BD
	 * 
	 * @param conseiller
	 * @return 1 si OK
	 */
	public int ajouterGerant(Gerant gerant);

	/**
	 * modifier un conseiller de la BD
	 * 
	 * @param conseiller
	 * @return 1 si OK
	 */
	public int modifierGerant(Gerant gerant);

	/**
	 * supprimer le conseiller de la BD
	 * 
	 * @param id
	 * @return 1 si OK
	 */
	public int supprimerGerant(int id);

	/**
	 * supprimer le conseiller de la BD
	 * 
	 * @param conseiller
	 * @return 1 si OK
	 */
	public int supprimerGerant(Gerant gerant);
}
