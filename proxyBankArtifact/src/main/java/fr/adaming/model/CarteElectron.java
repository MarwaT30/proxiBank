package fr.adaming.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;


@Entity(name = "CarteElectronEntity")
@Table(name = "cartes_Electroniques")
public class CarteElectron extends CarteBancaire implements Serializable{

	/**
	 * 
	 */
	@Transient
	private static final long serialVersionUID = 86L;

	@OneToOne
	@JoinColumn (name="num_compte")
	private CompteCourant compte;
	/**
	 * 
	 */
	public CarteElectron() {
		super();
		// TODO Auto-generated constructor stub
	}



	/**
	 * 
	 * @param id
	 * @param compte
	 */
	public CarteElectron(int id, CompteCourant compte) {
		super(id);
		this.compte = compte;
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



	/* (non-Javadoc)
	 * @see fr.adaming.model.CarteBancaire#toString()
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "CarteElectron [id_carte=" + this.getId_carte()+ "]";
	}

	
}
