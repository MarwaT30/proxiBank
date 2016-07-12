package fr.adaming.model;

import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity(name="ClientEntity")
@Table(name="clients")

public class Client extends Personne implements Serializable{

	
	/**
	 * 
	 */
	@Transient
	private static final long serialVersionUID = 1L;
	
	
	@Column(name="conseiller clientele")
	private ConseillerClientele conseiller;
	
	
	

	
	/**
	 * empty constructor for class Client
	 */
	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * constructor for class Client using the following parameters
	 * @param nom
	 * @param prenom
	 * @param adresse
	 * @param codePostal
	 * @param telephone
	 */
	public Client(String nom, String prenom, String adresse, int codePostal,
			long telephone) {
		super(nom, prenom, adresse, codePostal, telephone);
		// TODO Auto-generated constructor stub
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



}
