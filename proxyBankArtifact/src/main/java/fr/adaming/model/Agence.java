package fr.adaming.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity(name="agenceEntity")
@Table(name="agences")
public class Agence {
	@Id
	private String numero;
	@Column(name="date_creation")
	private Date dateCreation;

	// Association
	@OneToOne(mappedBy = "agence")
	private Gerant gerant;

	@OneToMany(mappedBy ="agence")
	private List<ConseillerClientele> conseillers;

	public Agence() {
		super();
	}

	/**
	 * 
	 * @param numero
	 * @param dateCreation
	 * @param gerant
	 * @param conseillers
	 */
	public Agence(String numero, Date dateCreation, Gerant gerant,
			List<ConseillerClientele> conseillers) {
		super();
		this.numero = numero;
		this.dateCreation = dateCreation;
		this.gerant = gerant;
		this.conseillers = conseillers;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public Gerant getGerant() {
		return gerant;
	}

	public void setGerant(Gerant gerant) {
		this.gerant = gerant;
	}

	public List<ConseillerClientele> getConseillers() {
		return conseillers;
	}

	public void setConseillers(List<ConseillerClientele> conseillers) {
		this.conseillers = conseillers;
	}
}
