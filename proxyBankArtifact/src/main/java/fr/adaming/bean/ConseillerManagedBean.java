package fr.adaming.bean;
import java.util.List;
import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


import fr.adaming.model.Client;
import fr.adaming.model.ConseillerClientele;
import fr.adaming.service.IConseillerService;

@ManagedBean(name = "conseillerMB")
@SessionScoped
public class ConseillerManagedBean implements Serializable {
	private static final long serialVersionUID = 6531335421273622698L;

	IConseillerService conseillerService;
	
	private ConseillerClientele conseiller;
	
	private List<ConseillerClientele> listeConseiller;
	
	private List<Client> listeClientsConseiller;

	/**
	 * 
	 */
	public ConseillerManagedBean() {
		super();
	}

	/**
	 * @return the conseiller
	 */
	public ConseillerClientele getConseiller() {
		return conseiller;
	}

	/**
	 * @param conseiller the conseiller to set
	 */
	public void setConseiller(ConseillerClientele conseiller) {
		this.conseiller = conseiller;
	}

	/**
	 * @return the listeConseiller
	 */
	public List<ConseillerClientele> getListeConseiller() {
		return listeConseiller;
	}

	/**
	 * @param listeConseiller the listeConseiller to set
	 */
	public void setListeConseiller(List<ConseillerClientele> listeConseiller) {
		this.listeConseiller = listeConseiller;
	}

	/**
	 * @return the listeClientsConseiller
	 */
	public List<Client> getListeClientsConseiller() {
		return listeClientsConseiller;
	}

	/**
	 * @param listeClientsConseiller the listeClientsConseiller to set
	 */
	public void setListeClientsConseiller(List<Client> listeClientsConseiller) {
		this.listeClientsConseiller = listeClientsConseiller;
	}
	
	
	/**
	 * @return the conseillerService
	 */
	public IConseillerService getConseillerService() {
		return conseillerService;
	}

	/**
	 * @param conseillerService the conseillerService to set
	 */
	public void setConseillerService(IConseillerService conseillerService) {
		this.conseillerService = conseillerService;
	}

//	public void ajouter(){
//		conseillerService.
//	}
	
}
