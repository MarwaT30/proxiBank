package fr.adaming.dao;

import java.util.List;

import fr.adaming.model.Client;
import fr.adaming.model.Compte;
import fr.adaming.model.CompteCourant;
import fr.adaming.model.CompteEpargne;

public interface ICompteDao {
	/**
	 * 
	 * @param numero
	 *            le numéro de compte
	 * @return le compte correspondant
	 */
	public Compte getCompteCourantByNumero(int numero);

	/**
	 * 
	 * @param numero
	 * @return
	 */
	public Compte getCompteEpargneByNumero(int numero);

	/**
	 * 
	 * @param client
	 * @return
	 */
	public CompteCourant getCompteCourantByClient(Client client);

	/**
	 * 
	 * @param client
	 * @return
	 */
	public CompteEpargne getEpargneByClient(Client client);

	/**
	 * 
	 * @param compteC
	 * @return
	 */
	public int ajouterCompteC(CompteCourant compteC);

	/**
	 * 
	 * @param compteC
	 * @return
	 */
	public int modifierCompteC(CompteCourant compteC);

	/**
	 * 
	 * @param compte
	 * @return
	 */
	public int supprimerCompteC(CompteCourant compteC);

	/**
	 * 
	 * @param compteC
	 * @return
	 */
	public int ajouterCompteE(CompteEpargne compteE);

	/**
	 * 
	 * @param compteC
	 * @return
	 */
	public int modifierCompteE(CompteEpargne compteE);

	/**
	 * 
	 * @param compte
	 * @return
	 */
	public int supprimerCompteE(CompteEpargne compteE);
}
