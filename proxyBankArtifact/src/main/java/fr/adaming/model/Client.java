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
	@JoinColumn (name="Id_Conseiller", nullable=false)
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

	/**
	 * @return the compteCourant
	 */
	public CompteCourant getCompteCourant() {
		return compteCourant;
	}

	/**
	 * @param compteCourant the compteCourant to set
	 */
	public void setCompteCourant(CompteCourant compteCourant) {
		this.compteCourant = compteCourant;
	}

	/**
	 * @return the compteEpargne
	 */
	public CompteEpargne getCompteEpargne() {
		return compteEpargne;
	}

	/**
	 * @param compteEpargne the compteEpargne to set
	 */
	public void setCompteEpargne(CompteEpargne compteEpargne) {
		this.compteEpargne = compteEpargne;
	}

	@Override
	public String toString() {
		return "Client [id = " + this.getId() + ", nom=" + this.getNom() + ", prenom=" + this.getPrenom()
				+ ", adresse=" + this.getAdresse() + ", codePostal=" + this.getCodePostal()
				+ ", ville=" + this.getVille() + ", telephone=" + this.getTelephone() + " ; conseiller=" + conseiller + ", compteCourant="
				+ compteCourant + ", compteEpargne=" + compteEpargne + "]\n";
	}
}