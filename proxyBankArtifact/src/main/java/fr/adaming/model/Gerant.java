package fr.adaming.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;





@Entity(name = "gerantEntity")
@Table(name = "gerants")
//@DiscriminatorValue(value="cad")

public class Gerant extends Personne implements Serializable {


	/**
	 * 
	 */
	@Transient
	private static final long serialVersionUID = 86L;
	
	@OneToMany(mappedBy="conseiller", fetch=FetchType.EAGER)
	private List<Client> clients;//=new ArrayList<Client>();
	/**
	 * empty constructor for class ConseillerClientele
	 */
	@OneToOne
	@JoinColumn(name="agence_id",nullable=false)
	private Agence agence;
	

	public Gerant() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * constructor for class ConseillerClientele using the following parameters:
	 * @param nom
	 * @param prenom
	 * @param adresse
	 * @param codePostal
	 * @param ville
	 * @param telephone
	 */
	public Gerant(String nom, String prenom, String adresse,
			int codePostal,String ville, long telephone) {
		super(nom, prenom, adresse, codePostal,ville, telephone);
		// TODO Auto-generated constructor stub
	}

	/**
	 * constructor for class ConseillerClientele using the following parameters:
	 * @param nom
	 * @param prenom
	 * @param adresse
	 * @param codePostal
	 * @param ville
	 * @param telephone
	 */
	public Gerant(String nom, String prenom, String adresse,
			int codePostal,String ville, long telephone,Agence agence) {
		super(nom, prenom, adresse, codePostal,ville, telephone);
		this.agence=agence;
	}

	/**
	 * @return the clients
	 */
	public List<Client> getClients() {
		return clients;
	}

	/**
	 * @param clients the clients to set
	 */
	public void setClients(List<Client> clients) {
		this.clients = clients;
	}

	/**
	 * @return the agence
	 */
	public Agence getAgence() {
		return agence;
	}

	/**
	 * @param agence the agence to set
	 */
	public void setAgence(Agence agence) {
		this.agence = agence;
	}
	
	

}
