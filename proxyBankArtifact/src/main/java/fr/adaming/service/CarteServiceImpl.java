package fr.adaming.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.adaming.dao.CarteDaoImpl;
import fr.adaming.dao.ICarteDao;
import fr.adaming.model.CarteBancaire;
import fr.adaming.model.Compte;
import fr.adaming.model.CompteCourant;

@Service
public class CarteServiceImpl implements ICarteService {
	@Autowired
	ICarteDao carteDao = new CarteDaoImpl();

	
	
	/**
	 * @return the carteDao
	 */
	public ICarteDao getCarteDao() {
		return carteDao;
	}

	/**
	 * @param carteDao the carteDao to set
	 */
	public void setCarteDao(ICarteDao carteDao) {
		this.carteDao = carteDao;
	}

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
