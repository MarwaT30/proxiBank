package fr.adaming.bean;
import java.util.List;
import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;






import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.adaming.model.Client;
import fr.adaming.model.ConseillerClientele;
import fr.adaming.model.Gerant;
import fr.adaming.service.IConseillerService;
import fr.adaming.service.IGerantService;

@ManagedBean(name="gerantBean")
@SessionScoped
@Component
public class GerantManagedBean {

	@Autowired
	private IGerantService gerantService;
	
	private Gerant gerant;
	
	//********************constructeurs***************

	public GerantManagedBean(IGerantService gerantService,
			Gerant gerant) {
		this.gerantService = gerantService;
		this.gerant = gerant;
	}

	public GerantManagedBean() {
		gerant=new Gerant();
		}
	//*************getter setter*****************

	public IGerantService getGerantService() {
		return gerantService;
	}

	public void setGerantService(IGerantService gerantService) {
		this.gerantService = gerantService;
	}

	public Gerant getGerant() {
		return gerant;
	}

	public void setGerant(Gerant gerant) {
		this.gerant = gerant;
	}
	
	//*****************methodes****************************
	public void addGearnt(){
		gerantService.ajouterGerant(gerant);
		gerant = new Gerant();
		
	}
	
	public void deleteGerant(){
		gerantService.supprimerGerant(gerant);
		gerant=new Gerant();
	}
	
	public void updateGerant(){
		gerantService.modifierGerant(gerant);
			}
	
	public List<Gerant> getGerantList(){
		return gerantService.getAllGerants();
			}
	
	
}