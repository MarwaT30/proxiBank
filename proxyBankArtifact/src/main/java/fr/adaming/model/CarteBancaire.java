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

	// Association
	@OneToOne
	@JoinColumn(name = "compte_id", referencedColumnName = "id_compte")
	private CompteCourant compte;

	public CompteCourant getCompte() {
		return compte;
	}

	public void setCompte(CompteCourant compte) {
		this.compte = compte;
	}

}
