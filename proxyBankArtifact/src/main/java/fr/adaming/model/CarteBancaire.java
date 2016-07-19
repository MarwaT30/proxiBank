package fr.adaming.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;

@MappedSuperclass
public abstract class CarteBancaire {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id_carte;

	@OneToOne
	@JoinColumn (name="num_compte")
	private CompteCourant compte;
	
	
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
	 * @param id_carte
	 */
	public CarteBancaire(int id_carte,CompteCourant compte) {
		super();
		this.id_carte = id_carte;
		this.compte = compte;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CarteBancaire [id_carte=" + id_carte + "]";
	}
	
	

	// Association
//	@OneToOne
//	@JoinColumn(name = "compte_id", referencedColumnName = "id_compte")
//	private CompteCourant compteLie;

//	public CompteCourant getCompteLie() {
//		return compteLie;
//	}
//
//	public void setCompteLie(CompteCourant compte) {
//		this.compteLie = compte;
//	}

}
