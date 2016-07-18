package fr.adaming.service;

import fr.adaming.dao.AgenceDaoImpl;
import fr.adaming.dao.IAgenceDao;
import fr.adaming.model.Agence;

public class AgenceServiceImpl implements IAgenceService {
	IAgenceDao agenceDao = new AgenceDaoImpl();

	@Override
	public Agence getAgenceByNumero(int agence) {
		return agenceDao.getAgenceByNumero(agence);
	}

	@Override
	public int ajouterAgence(Agence agence) {
		return agenceDao.ajouterAgence(agence);
	}

	@Override
	public int modifierAgence(Agence agence) {
		return agenceDao.modifierAgence(agence);
	}

	@Override
	public int supprimerAgence(Agence agence) {
		return agenceDao.supprimerAgence(agence);
	}
}