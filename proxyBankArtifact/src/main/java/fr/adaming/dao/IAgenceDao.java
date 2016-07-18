package fr.adaming.dao;

import java.util.List;

import fr.adaming.model.Agence;
import fr.adaming.model.Compte;



public interface IAgenceDao {
	/**
	 * 
	 * @param numero
	 *            le numéro de l'agence
	 * @return l'agence correspondante
	 */
	public Agence getAgenceByNumero(int agence);

	/**
	 * 
	 * @return
	 */
	public List<Agence> getAllAgences();
	
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
