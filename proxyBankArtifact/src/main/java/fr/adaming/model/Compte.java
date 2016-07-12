package fr.adaming.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;

@MappedSuperclass
public abstract class Compte {
	@ManyToOne
	@JoinColumn(name="client_id_fk", referencedColumnName="id_client")
	private Client client;
	@Id
	@Column(name = "numero_compte")
	private int numero;
	@Column(name = "solde")
	private float solde;
	@Column(name = "date_ouverture")
	private Date dateOuverture;

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
		this.idClient = client.getId();
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

}
