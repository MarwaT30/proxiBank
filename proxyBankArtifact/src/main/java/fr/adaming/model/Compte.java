package fr.adaming.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Compte {

	@Id
	@Column(name = "id_compte")
	private int numero;
	@Column(name = "solde")
	private float solde;
	@Column(name = "date_ouverture")
	private Date dateOuverture;

	@ManyToOne
	@JoinColumn(name = "client", referencedColumnName = "id")
	private Client client;

	/**
	 * ctor vide
	 */
	public Compte() {
		super();
	}

	/**
	 * ctor
	 * 
	 * @param client
	 * @param numero
	 * @param solde
	 * @param dateOuverture
	 */
	public Compte(Client client, int numero, float solde, Date dateOuverture) {
		super();
		this.client = client;
		this.numero = numero;
		this.solde = solde;
		this.dateOuverture = dateOuverture;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

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
