package fr.adaming.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;

@MappedSuperclass
public abstract class Compte {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_compte")
	private int numero;
	@Column(name = "solde")
	private float solde;
	@Column(name = "date_ouverture")
	private Date dateOuverture;

//	@OneToOne
//	@JoinColumn(name = "client", referencedColumnName = "id")
//	private Client client;

	/**
	 * empty constructor for class Compte
	 */
	public Compte() {
		super();
	}
	
	

/**
 * constructor for class Compte 
 * @param numero
 * @param solde
 * @param dateOuverture
 */
public Compte(int numero, float solde, Date dateOuverture) {
	super();
	this.numero = numero;
	this.solde = solde;
	this.dateOuverture = dateOuverture;
}

/**
 * constructor for class Compte
 * @param solde
 * @param dateOuverture
 */
public Compte( float solde, Date dateOuverture) {
	super();
	
	this.solde = solde;
	this.dateOuverture = dateOuverture;
}


//	/**
//	 * ctor
//	 * 
//	 * @param client
//	 * @param numero
//	 * @param solde
//	 * @param dateOuverture
//	 */
//	public Compte(Client client, int numero, float solde, Date dateOuverture) {
//		super();
//		this.client = client;
//		this.numero = numero;
//		this.solde = solde;
//		this.dateOuverture = dateOuverture;
//	}
//
//	public Client getClient() {
//		return client;
//	}
//
//	public void setClient(Client client) {
//		this.client = client;
//	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public float getSolde() {
		return solde;
	}

	public void setSolde(float solde) {
		this.solde = solde;
	}

	public Date getDateOuverture() {
		return dateOuverture;
	}

	public void setDateOuverture(Date dateOuverture) {
		this.dateOuverture = dateOuverture;
	}

	public int retirer(double somme) {
		// TODO
		return 1;
	}

	public int deposer(double somme) {
		// TODO
		return 1;
	}

	
	
}
