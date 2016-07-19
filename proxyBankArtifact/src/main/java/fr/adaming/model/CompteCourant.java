package fr.adaming.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
	
	@OneToOne(mappedBy="compte",cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
	private CarteBancaire carte;
	
	@OneToOne
	@JoinColumn (name="id_client")
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
	 * @param carte
	 */
	public CompteCourant(int numero, float solde,
			Date dateOuverture,Client client, float autDecouvert, CarteBancaire carte) {
		super(numero, solde, dateOuverture);
		this.client=client;
		this.autDecouvert=autDecouvert;
		this.carte=carte;
	}

	
	
	/**
	 * @return the carte
	 */
	public CarteBancaire getCarte() {
		return carte;
	}


	/**
	 * @param carte the carte to set
	 */
	public void setCarte(CarteBancaire carte) {
		this.carte = carte;
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
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Compte [numero=" + this.getNumero() + ", solde=" + this.getSolde()
				+ ", dateOuverture=" + this.getDateOuverture()+ ", autorisation decouvert=" + this.autDecouvert+"";// ", client="+this.client+" ]";
	}
}
