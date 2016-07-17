package fr.adaming.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
	@JoinColumn(name="agence_id",nullable=false)
	private Agence agence;
	
	@OneToMany(mappedBy="conseiller",cascade=CascadeType.REMOVE, fetch=FetchType.EAGER)
	private List<Client> clients;//=new ArrayList<Client>();
	/**
	 * empty constructor for class ConseillerClientele
	 */
	public ConseillerClientele() {
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
	public ConseillerClientele(String nom, String prenom, String adresse,
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
	public ConseillerClientele(String nom, String prenom, String adresse,
			int codePostal,String ville, long telephone,Agence agence) {
		super(nom, prenom, adresse, codePostal,ville, telephone);
		this.agence=agence;
	}

	
}
