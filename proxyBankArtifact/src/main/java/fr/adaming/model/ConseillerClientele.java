package fr.adaming.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import fr.adaming.model.*;

@Entity(name="consEntity")
@Table(name="conseillers")
public class ConseillerClientele extends Personne implements Serializable{

	@Transient
	private static final long serialVersionUID = 86L;

	@ManyToOne
	@JoinColumn(name="agence_id",referencedColumnName="id_agence")
	private Agence agence;
	
	@OneToMany(mappedBy="conseiller",cascade=CascadeType.ALL)
	private List<Client> clients;//=new ArrayList<Client>();
	/**
	 * empty constructor for class ConseillerClientele
	 */
	public ConseillerClientele() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * constructor for class ConseillerClientele using th following parameters:
	 * @param nom
	 * @param prenom
	 * @param adresse
	 * @param codePostal
	 * @param telephone
	 */
	public ConseillerClientele(String nom, String prenom, String adresse,
			int codePostal, long telephone) {
		super(nom, prenom, adresse, codePostal, telephone);
		// TODO Auto-generated constructor stub
	}

	/**
	 * constructor for class ConseillerClientele using th following parameters:
	 * @param nom
	 * @param prenom
	 * @param adresse
	 * @param codePostal
	 * @param telephone
	 */
	public ConseillerClientele(String nom, String prenom, String adresse,
			int codePostal, long telephone,Agence agence) {
		super(nom, prenom, adresse, codePostal, telephone);
		// TODO Auto-generated constructor stub
	}

	
}
