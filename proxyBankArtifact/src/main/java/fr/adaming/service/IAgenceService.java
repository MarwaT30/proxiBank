package fr.adaming.service;

import fr.adaming.model.Agence;

public interface IAgenceService {
	/**
	 * 
	 * @param numero
	 *            le numéro de l'agence
	 * @return l'agence correspondante
	 */
	public Agence getAgenceByNumero(int agence);

	/**
	 * 
	 * @param agence
	 * @return 1 si OK
	 */
	public int ajouterAgence(Agence agence);

	/**
	 * 
	 * @param agence
	 * @return
	 */
	public int modifierAgence(Agence agence);

	/**
	 * 
	 * @param agence
	 * @return
	 */
	public int supprimerAgence(Agence agence);
	
}
