package fr.adaming.model;

import javax.persistence.Column;

public class CompteCourant extends Compte {
	/**
	 * le découvert autorisé (positif)
	 */
	@Column(name = "aut_decouvert")
	private float autDecouvert;

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
