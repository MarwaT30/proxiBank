package fr.adaming.dao;

import fr.adaming.model.CarteBancaire;
import fr.adaming.model.CarteElectron;
import fr.adaming.model.CartePremier;
import fr.adaming.model.Compte;
import fr.adaming.model.CompteCourant;

public interface ICarteDao {
	/**
	 * 
	 * @param id
	 * @return
	 */
	public CarteBancaire getCarteElectronByCompte(CompteCourant compte);

	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public CarteBancaire getCartePremiumByCompte(int id);

	/**
	 * 
	 * @param id
	 * @return
	 */
	public Compte getCompteByCarteElectron(CarteBancaire carte);

	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public Compte getCompteByCartePremium(CarteBancaire carte);
	
	/**
	 * 
	 * @param carte
	 * @return
	 */
	public int ajouterCarteElectron(CarteElectron carte);

	
	/**
	 * 
	 * @param carte
	 * @return
	 */
	public int ajouterCartePremium(CartePremier carte);
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
