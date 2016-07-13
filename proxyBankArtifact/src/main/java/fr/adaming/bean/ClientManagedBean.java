package fr.adaming.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import fr.adaming.model.Client;
import fr.adaming.service.IClientService;

@ManagedBean(name = "clientMB")
@SessionScoped
public class ClientManagedBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private int id;
	private String nom, prenom, adresse;
	private int codePostal;
	private long telephone;
	IClientService clientService;

	/**
	 * Pour créer le client à partir du formulaire
	 */
	public void ajouter() {
		System.out.println(this.getNom() + this.getPrenom() + this.getAdresse()
				+ this.getCodePostal() + this.getTelephone());
		// clientService.ajouterClient(new Client(this.getNom(),
		// this.getPrenom(),
		// this.getAdresse(), this.getCodePostal(), this.getTelephone()));
	}

	/**
	 * ctor vide
	 */
	public ClientManagedBean() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public int getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(int codePostal) {
		this.codePostal = codePostal;
	}

	public long getTelephone() {
		return telephone;
	}

	public void setTelephone(long telephone) {
		this.telephone = telephone;
	}
}
