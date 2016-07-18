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

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;





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
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Client> clients;//=new ArrayList<Client>();
	/**
	 * empty constructor for class ConseillerClientele
	 */
	@OneToOne
	@JoinColumn(name="agence_id",referencedColumnName="id_agence")
	private Agence agence_gerant;
	

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
		this.agence_gerant=agence;
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
	 * @return the agence_gerant
	 */
	public Agence getAgence_gerant() {
		return agence_gerant;
	}

	/**
	 * @param agence_gerant the agence_gerant to set
	 */
	public void setAgence_gerant(Agence agence_gerant) {
		this.agence_gerant = agence_gerant;
	}

	
	
	

}
