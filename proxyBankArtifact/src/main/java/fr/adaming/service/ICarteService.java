package fr.adaming.service;

import fr.adaming.model.CarteBancaire;
import fr.adaming.model.Compte;
import fr.adaming.model.CompteCourant;

public interface ICarteService {
	/**
	 * 
	 * @param id
	 * @return
	 */
	public CarteBancaire getCarteByCompte(CompteCourant compte);

	
	

	

	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public Compte getCompteByCarte(CarteBancaire carte);
	
	
	
	/**
	 * 
	 * @param carte
	 * @return
	 */
	public int ajouterCarte(CarteBancaire carte);

	
	/**
	 * 
	 * @param compte
	 * @return
	 */
	public int modifierCarte(CarteBancaire carte);

	/**
	 * 
	 * @param carte
	 * @return
	 */
	public int supprimerCarte(CarteBancaire carte);
}
