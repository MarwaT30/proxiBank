package fr.adaming.model;

import javax.persistence.OneToOne;

public class CompteEpargne extends Compte {
	
	private float taux;
	
	// Association
	@OneToOne(mappedBy = "compte")
	private CarteBancaire carte;

	public CompteEpargne() {
		taux = 3;
	}

	public CompteEpargne(float taux) {
		super();
		this.taux = taux;
	}

	public float getTaux() {
		return taux;
	}

	public void setTaux(float taux) {
		this.taux = taux;
	}
}
