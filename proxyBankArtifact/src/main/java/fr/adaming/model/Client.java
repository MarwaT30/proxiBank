package fr.adaming.model;

import java.io.Serializable;





import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity(name="ClientEntity")
@Table(name="clients")

public class Client extends Personne implements Serializable{

	@Transient
	private static final long serialVersionUID = 86L;
	
	@ManyToOne
	@JoinColumn(name="client_id",referencedColumnName="id")
	@Column(name="conseiller clientele")
	private ConseillerClientele conseiller;
	
	@OneToMany(mappedBy="client",cascade=CascadeType.ALL)
	private List<Compte> commandesList;

	

	
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
	 * constructor for class Client using the following parameters
	 * @param nom
	 * @param prenom
	 * @param adresse
	 * @param codePostal
	 * @param telephone
	 * @param conseiller
	 */
	public Client(String nom, String prenom, String adresse, int codePostal,
			long telephone, ConseillerClientele conseiller) {
		super(nom, prenom, adresse, codePostal, telephone);
		this.conseiller=conseiller;

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
