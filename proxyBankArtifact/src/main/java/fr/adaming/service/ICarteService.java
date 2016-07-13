package fr.adaming.service;

import fr.adaming.model.CarteBancaire;
import fr.adaming.model.Compte;

public interface ICarteService {
	/**
	 * 
	 * @param id
	 * @return
	 */
	public Compte getCarteById(int id);

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
	public int modifierCompte(Compte compte);

	/**
	 * 
	 * @param carte
	 * @return
	 */
	public int supprimerCarte(CarteBancaire carte);
}
