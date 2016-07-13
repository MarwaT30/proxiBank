package fr.adaming.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity(name = "gerantEntity")
@Table(name = "gerants")
public class Gerant extends ConseillerClientele implements Serializable {
//	// Association
//	@OneToOne
//	@JoinColumn(name = "agence_gerant", referencedColumnName = "id_agence")
//	private Agence agence;

	/**
	 * 
	 */
	@Transient
	private static final long serialVersionUID = 86L;

	/**
	 * empty constructor for class Gerant
	 */
	public Gerant() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * constructor for class Gerant using the following parameters:
	 * 
	 * @param nom
	 * @param prenom
	 * @param adresse
	 * @param codePostal
	 * @param telephone
	 * @param agence
	 */
	public Gerant(String nom, String prenom, String adresse, int codePostal,
			long telephone, Agence agence) {
		super(nom, prenom, adresse, codePostal, telephone, agence);
		// TODO Auto-generated constructor stub
	}

	/**
	 * constructor for class Gerant using the following parameters:
	 * 
	 * @param nom
	 * @param prenom
	 * @param adresse
	 * @param codePostal
	 * @param telephone
	 */
	public Gerant(String nom, String prenom, String adresse, int codePostal,
			long telephone) {
		super(nom, prenom, adresse, codePostal, telephone);
		// TODO Auto-generated constructor stub
	}

}
