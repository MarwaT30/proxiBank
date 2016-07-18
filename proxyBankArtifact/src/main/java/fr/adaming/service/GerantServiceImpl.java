package fr.adaming.service;

import java.util.List;

import fr.adaming.dao.GerantDaoImpl;
import fr.adaming.dao.IGerantDao;
import fr.adaming.model.Agence;
import fr.adaming.model.Gerant;

public class GerantServiceImpl implements IGerantService {
	IGerantDao gerantDao = new GerantDaoImpl();

	@Override
	public List<Gerant> getAllGerants() {
		return gerantDao.getAllGerants();
	}

	@Override
	public List<Gerant> getGerantsByAgence(Agence agence) {
		return gerantDao.getGerantsByAgence(agence);
	}

	@Override
	public int ajouterGerant(Gerant gerant) {
		return gerantDao.ajouterGerant(gerant);
	}

	@Override
	public int modifierGerant(Gerant gerant) {
		return gerantDao.modifierGerant(gerant);
	}

	@Override
	public int supprimerGerant(int id) {
		return gerantDao.supprimerGerant(id);
	}

	@Override
	public int supprimerGerant(Gerant gerant) {
		return gerantDao.supprimerGerant(gerant);
	}

}
