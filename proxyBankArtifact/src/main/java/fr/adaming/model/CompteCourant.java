package fr.adaming.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity(name = "compteCourantEntity")
@Table(name = "comptes_courants")
public class CompteCourant extends Compte {
	/**
	 * le découvert autorisé (positif)
	 */
	@Column(name = "aut_decouvert")
	private float autDecouvert;
	
//	@OneToOne(mappedBy="compteLie")
//	private CarteBancaire carte;
	
	@OneToOne
	@JoinColumn (name="id_client", nullable=false)
	private Client client;

	/**
	 * 
	 */
	public CompteCourant() {
		super();
	}


	/**
	 * @param solde
	 * @param dateOuverture
	 */
	public CompteCourant(float solde, Date dateOuverture) {
		super(solde, dateOuverture);
		// TODO Auto-generated constructor stub
	}


	/**
	 * 
	 * @param numero
	 * @param solde
	 * @param dateOuverture
	 * @param client
	 * @param autDecouvert
	 */
	public CompteCourant(int numero, float solde,
			Date dateOuverture,Client client, float autDecouvert) {
		super(numero, solde, dateOuverture);
		this.client=client;
		this.autDecouvert=autDecouvert;
	}

	public float getAutDecouvert() {
		return autDecouvert;
	}

	public void setAutDecouvert(float autDecouvert) {
		this.autDecouvert = autDecouvert;
	}


	/**
	 * @return the client
	 */
	public Client getClient() {
		return client;
	}


	/**
	 * @param client the client to set
	 */
	public void setClient(Client client) {
		this.client = client;
	}
	
}
