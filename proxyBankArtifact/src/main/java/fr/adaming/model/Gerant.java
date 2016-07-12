package fr.adaming.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity(name="GerantEntity")
@Table(name="gerants")
public class Gerant extends ConseillerClientele implements Serializable{

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
