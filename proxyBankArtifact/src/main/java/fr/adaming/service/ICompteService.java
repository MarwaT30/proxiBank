package fr.adaming.service;

import fr.adaming.model.Compte;

public interface ICompteService {
	/**
	 * 
	 * @param numero
	 *            le numéro de compte
	 * @return le compte correspondant
	 */
	public Compte getCompteByNumero(int numero);

	/**
	 * 
	 * @param compte
	 * @return 1 si OK
	 */
	public int ajouterCompte(Compte compte);

	/**
	 * 
	 * @param compte
	 * @return
	 */
	public int modifierCompte(Compte compte);

	/**
	 * 
	 * @param compte
	 * @return
	 */
	public int supprimerCompte(Compte compte);
}
