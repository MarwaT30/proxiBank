package fr.adaming.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity(name="carteEntity")
@Table(name="cartes")
public class CarteBancaire {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id_carte;

	@Column(name="type")
	private String type;
	
	@OneToOne
	@JoinColumn (name="num_compte")
	private CompteCourant compte;
	
	
	
	
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}



	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}



	/**
	 * @return the compte
	 */
	public CompteCourant getCompte() {
		return compte;
	}



	/**
	 * @param compte the compte to set
	 */
	public void setCompte(CompteCourant compte) {
		this.compte = compte;
	}
	
	/**
	 * @return the id_carte
	 */
	public int getId_carte() {
		return id_carte;
	}

	/**
	 * @param id_carte the id_carte to set
	 */
	public void setId_carte(int id_carte) {
		this.id_carte = id_carte;
	}

	/**
	 * 
	 */
	public CarteBancaire() {
		super();
	}



	/**
	 * @param type
	 */
	public CarteBancaire(String type) {
		super();
		this.type = type;
	}



	/**
	 * @param id_carte
	 * @param type
	 * @param compte
	 */
	public CarteBancaire(int id_carte, String type, CompteCourant compte) {
		super();
		this.id_carte = id_carte;
		this.type = type;
		this.compte = compte;
	}

	

	
	
}
