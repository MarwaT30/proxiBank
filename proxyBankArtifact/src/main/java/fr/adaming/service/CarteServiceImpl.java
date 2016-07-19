package fr.adaming.service;

import fr.adaming.dao.CarteDaoImpl;
import fr.adaming.dao.ICarteDao;
import fr.adaming.model.CarteBancaire;
import fr.adaming.model.Compte;

public class CarteServiceImpl implements ICarteService {
	ICarteDao carteDao = new CarteDaoImpl();

	

}
