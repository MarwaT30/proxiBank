package fr.adaming.service;

import fr.adaming.dao.CarteDaoImpl;
import fr.adaming.dao.ICarteDao;
import fr.adaming.model.CarteBancaire;
import fr.adaming.model.Compte;
import fr.adaming.model.CompteCourant;

public class CarteServiceImpl implements ICarteService {
	ICarteDao carteDao = new CarteDaoImpl();

	@Override
	public CarteBancaire getCarteByCompte(CompteCourant compte) {
		
		return carteDao.getCarteByCompte(compte);
	}

	@Override
	public Compte getCompteByCarte(CarteBancaire carte) {
		
		return carte.getCompte();
	}

	@Override
	public int ajouterCarte(CarteBancaire carte) {
	
		carteDao.ajouterCarte(carte);
		return 1;
	}

	@Override
	public int modifierCarte(CarteBancaire carte) {
		carteDao.modifierCarte(carte);
		return 0;
	}

	@Override
	public int supprimerCarte(CarteBancaire carte) {
		carteDao.supprimerCarte(carte);
		return 0;
	}

	

}
