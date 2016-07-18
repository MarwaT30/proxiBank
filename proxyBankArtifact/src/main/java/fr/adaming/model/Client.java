package fr.adaming.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity(name = "clientEntity")
@Table(name = "clients")
public class Client extends Personne implements Serializable {
	@Transient
	private static final long serialVersionUID = 86L;

	@ManyToOne
	@JoinColumn(name = "conseiller_id", nullable = false)
	private ConseillerClientele conseiller;

	@OneToOne(mappedBy = "client", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
	private CompteCourant compteCourant;

	@OneToOne(mappedBy = "client", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)	
	private CompteEpargne compteEpargne;

	/**
	 * empty constructor for class Client
	 */
	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * constructor for class Client using the following parameters
	 * 
	 * @param nom
	 * @param prenom
	 * @param adresse
	 * @param codePostal
	 * @param ville
	 * @param telephone
	 */
	public Client(String nom, String prenom, String adresse, int codePostal,
			String ville, long telephone) {
		super(nom, prenom, adresse, codePostal, ville, telephone);
		// TODO Auto-generated constructor stub
	}

	/**
	 * constructor for class Client using the following parameters
	 * 
	 * @param nom
	 * @param prenom
	 * @param adresse
	 * @param codePostal
	 * @param ville
	 * @param telephone
	 * @param conseiller
	 */
	public Client(String nom, String prenom, String adresse, int codePostal,
			String ville, long telephone, ConseillerClientele conseiller) {
		super(nom, prenom, adresse, codePostal, ville, telephone);
		this.conseiller = conseiller;

		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the conseiller
	 */
	public ConseillerClientele getConseiller() {
		return conseiller;
	}

	/**
	 * @param conseiller
	 *            the conseiller to set
	 */
	public void setConseiller(ConseillerClientele conseiller) {
		this.conseiller = conseiller;
	}

	@Override
	public String toString() {
		return "Client" + super.toString() + " ; conseiller=" + conseiller + ", compteCourant="
				+ compteCourant + ", compteEpargne=" + compteEpargne + "]";
	}

}
