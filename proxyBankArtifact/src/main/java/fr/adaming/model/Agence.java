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
	@Column(name="id_agence")
	private int numero;
	@Column(name="date_creation")
	private Date dateCreation;

	// Association
//	@OneToOne(mappedBy = "agence_gerant")
	//private Gerant gerant;

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
	public Agence(int numero, Date dateCreation, 
			List<ConseillerClientele> conseillers) {
		super();
		this.numero = numero;
		this.dateCreation = dateCreation;
		this.conseillers = conseillers;
	}
	
	/**
	 * 
	 * @param dateCreation
	 */
	public Agence( Date dateCreation) {
		super();

		this.dateCreation = dateCreation;
		
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}


	public List<ConseillerClientele> getConseillers() {
		return conseillers;
	}

	public void setConseillers(List<ConseillerClientele> conseillers) {
		this.conseillers = conseillers;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Agence [numero=" + numero + ", dateCreation=" + dateCreation
				+  ", conseillers=" + conseillers + "]";
	}
	
	
}
