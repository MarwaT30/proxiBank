package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.adaming.dao.CompteDaoImpl;
import fr.adaming.dao.ICompteDao;
import fr.adaming.model.Client;
import fr.adaming.model.Compte;
import fr.adaming.model.CompteCourant;
import fr.adaming.model.CompteEpargne;
@Service
public class CompteServiceImpl implements ICompteService {
	@Autowired
	ICompteDao compteDao = new CompteDaoImpl();

	
	/**
	 * @return the compteDao
	 */
	public ICompteDao getCompteDao() {
		return compteDao;
	}

	/**
	 * @param compteDao the compteDao to set
	 */
	public void setCompteDao(ICompteDao compteDao) {
		this.compteDao = compteDao;
	}

	@Override
	public Compte getCompteCourantByNumero(int numero) {
		return compteDao.getCompteCourantByNumero(numero);
	}

	@Override
	public Compte getCompteEpargneByNumero(int numero) {
		return compteDao.getCompteEpargneByNumero(numero);
	}

	@Override
	public List<CompteCourant> getCompteCourantByClient(Client client) {
		return compteDao.getCompteCourantByClient(client);
	}

	@Override
	public List<CompteEpargne> getEpargneByClient(Client client) {
		return compteDao.getEpargneByClient(client);
	}

	@Override
	public int ajouterCompteC(CompteCourant compteC) {
		return compteDao.ajouterCompteC(compteC);
	}

	@Override
	public int modifierCompteC(CompteCourant compteC) {
		return compteDao.modifierCompteC(compteC);
	}

	@Override
	public int supprimerCompteC(CompteCourant compteC) {
		return compteDao.supprimerCompteC(compteC);
	}

	@Override
	public int ajouterCompteE(CompteEpargne compteE) {
		return compteDao.ajouterCompteE(compteE);
	}

	@Override
	public int modifierCompteE(CompteEpargne compteE) {
		return compteDao.modifierCompteE(compteE);
	}

	@Override
	public int supprimerCompteE(CompteEpargne compteE) {
		return compteDao.supprimerCompteE(compteE);
	}
}