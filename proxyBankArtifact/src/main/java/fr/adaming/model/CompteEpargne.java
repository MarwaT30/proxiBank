package fr.adaming.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity(name = "compteEpargneEntity")
@Table(name = "comptes_epargne")
public class CompteEpargne extends Compte {
	
	@Column(name = "taux")
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
