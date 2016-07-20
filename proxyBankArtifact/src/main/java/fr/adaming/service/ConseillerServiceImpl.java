package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.adaming.dao.IConseillerDao;
import fr.adaming.model.Agence;
import fr.adaming.model.ConseillerClientele;


@Service
public class ConseillerServiceImpl implements IConseillerService{

	@Autowired
	private IConseillerDao consDao;

	/**
	 * @param consService the consService to set
	 */
	public void setConsDao(IConseillerDao consDao) {
		this.consDao = consDao;
	}

	@Override
	public List<ConseillerClientele> getAllConseillers() {
		
		return consDao.getAllConseillers();
	}

	@Override
	public List<ConseillerClientele> getConseillersByAgence(Agence agence) {
		
		return consDao.getConseillersByAgence(agence);
	}

	@Override
	public void ajouterConseiller(ConseillerClientele conseiller) {
		consDao.ajouterConseiller(conseiller);
	
	}

	@Override
	public void modifierConseiller(ConseillerClientele conseiller) {
		consDao.modifierConseiller(conseiller);

	}

	@Override
	public void supprimerConseiller(int id) {
		consDao.supprimerConseiller(id);
	}

	@Override
	public void supprimerConseiller(ConseillerClientele conseiller) {
		consDao.supprimerConseiller(conseiller);
	}

	@Override
	public ConseillerClientele getConseillerById(int id) {
		
		return consDao.getConseillerById(id);
	}

}
