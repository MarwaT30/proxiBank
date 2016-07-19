package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.adaming.dao.GerantDaoImpl;
import fr.adaming.dao.IGerantDao;
import fr.adaming.model.Agence;
import fr.adaming.model.Gerant;
@Service
public class GerantServiceImpl implements IGerantService {
	@Autowired
	IGerantDao gerantDao = new GerantDaoImpl();

	/**
	 * @return the gerantDao
	 */
	public IGerantDao getGerantDao() {
		return gerantDao;
	}

	/**
	 * @param gerantDao the gerantDao to set
	 */
	public void setGerantDao(IGerantDao gerantDao) {
		this.gerantDao = gerantDao;
	}

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
