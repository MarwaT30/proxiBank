package fr.adaming.bean;
import java.util.List;
import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.adaming.model.Client;
import fr.adaming.model.ConseillerClientele;
import fr.adaming.service.IConseillerService;

@ManagedBean(name="conseillerBean")
@SessionScoped
@Component
public class ConseillerManagedBean {

	@Autowired
	private IConseillerService conseillerService;
	
	private ConseillerClientele conseiller;
	
	//********************constructeurs***************

	public ConseillerManagedBean(IConseillerService conseillerService,
			ConseillerClientele conseiller) {
		this.conseillerService = conseillerService;
		this.conseiller = conseiller;
	}

	public ConseillerManagedBean() {
		conseiller=new ConseillerClientele();
		}
	//*************getter setter*****************

	public IConseillerService getConseillerService() {
		return conseillerService;
	}

	public void setConseillerService(IConseillerService conseillerService) {
		this.conseillerService = conseillerService;
	}

	public ConseillerClientele getConseiller() {
		return conseiller;
	}

	public void setConseiller(ConseillerClientele conseiller) {
		this.conseiller = conseiller;
	}
	
	//*****************methodes****************************
	public void addConseiller(){
		conseillerService.ajouterConseiller(conseiller);
		conseiller = new ConseillerClientele();
		
	}
	
	public void deleteConseiller(){
		conseillerService.supprimerConseiller(conseiller);
		conseiller=new ConseillerClientele();
	}
	
	public void updateConseiller(){
		conseillerService.modifierConseiller(conseiller);
			}
	
	public List<ConseillerClientele> getConseillerList(){
		return conseillerService.getAllConseillers();
			}
	
	
}