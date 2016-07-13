package fr.adaming.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity(name = "compteCourantEntity")
@Table(name = "comptes_courants")
public class CompteCourant extends Compte {
	/**
	 * le découvert autorisé (positif)
	 */
	@Column(name = "aut_decouvert")
	private float autDecouvert;
	
	@OneToOne(mappedBy="compteLie")
	private CarteBancaire carte;

	public CompteCourant() {
		autDecouvert = 1000;
	}

	public CompteCourant(float autDecouvert) {
		super();
		this.autDecouvert = autDecouvert;
	}

	public float getAutDecouvert() {
		return autDecouvert;
	}

	public void setAutDecouvert(float autDecouvert) {
		this.autDecouvert = autDecouvert;
	}
}
