package fr.adaming.service;

import fr.adaming.dao.CarteDaoImpl;
import fr.adaming.dao.ICarteDao;
import fr.adaming.model.CarteBancaire;
import fr.adaming.model.Compte;

public class CarteServiceImpl implements ICarteService {
	ICarteDao carteDao = new CarteDaoImpl();

	@Override
	public Compte getCarteById(int id) {
		return carteDao.getCarteById(id);
	}

	@Override
	public int ajouterCarte(CarteBancaire carte) {
		return carteDao.ajouterCarte(carte);
	}

	@Override
	public int modifierCarte(Compte compte) {
		return carteDao.modifierCarte(compte);
	}

	@Override
	public int supprimerCarte(CarteBancaire carte) {
		return carteDao.supprimerCarte(carte);
	}

}
