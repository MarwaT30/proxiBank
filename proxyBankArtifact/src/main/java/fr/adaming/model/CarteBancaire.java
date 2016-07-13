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
	private CompteCourant compteLie;

	public CompteCourant getCompteLie() {
		return compteLie;
	}

	public void setCompteLie(CompteCourant compte) {
		this.compteLie = compte;
	}

}
