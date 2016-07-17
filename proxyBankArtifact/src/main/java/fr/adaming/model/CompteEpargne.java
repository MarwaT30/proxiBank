package fr.adaming.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity(name = "compteEpargneEntity")
@Table(name = "comptes_epargne")
public class CompteEpargne extends Compte {
	
	@Column(name = "taux")
	private float taux;
	
	@OneToOne(mappedBy="compteCourant")
	private Client client;
	
	

	/**
	 * 
	 */
	public CompteEpargne() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	/**
	 * @param numero
	 * @param solde
	 * @param dateOuverture
	 */
	public CompteEpargne(float solde, Date dateOuverture) {
		super( solde, dateOuverture);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param numero
	 * @param solde
	 * @param dateOuverture
	 */
	public CompteEpargne(int numero, float solde, Date dateOuverture,Client client, float taux ) {
		super(numero, solde, dateOuverture);
		this.client=client;
		this.taux=taux;
		// TODO Auto-generated constructor stub
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

	public float getTaux() {
		return taux;
	}

	public void setTaux(float taux) {
		this.taux = taux;
	}
}
