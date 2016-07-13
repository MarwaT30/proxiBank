package fr.adaming.service;

import fr.adaming.dao.CompteDaoImpl;
import fr.adaming.dao.ICompteDao;
import fr.adaming.model.Compte;

public class CompteServiceImpl implements ICompteService {
	ICompteDao compteDao = new CompteDaoImpl();

	@Override
	public Compte getCompteByNumero(int numero) {
		return compteDao.getCompteByNumero(numero);
	}

	@Override
	public int ajouterCompte(Compte compte) {
		return compteDao.ajouterCompte(compte);
	}

	@Override
	public int modifierCompte(Compte compte) {
		return compteDao.modifierCompte(compte);
	}

	@Override
	public int supprimerCompte(Compte compte) {
		return compteDao.supprimerCompte(compte);
	}

}
