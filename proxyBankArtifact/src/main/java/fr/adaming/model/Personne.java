package fr.adaming.model;

public class Personne {

	private int id;
	private String nom;
	private String prenom;
	private String adresse;
	private int codePostal;
	private long telephone;
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}
	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	/**
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}
	/**
	 * @param prenom the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	/**
	 * @return the adresse
	 */
	public String getAdresse() {
		return adresse;
	}
	/**
	 * @param adresse the adresse to set
	 */
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	/**
	 * @return the codePostal
	 */
	public int getCodePostal() {
		return codePostal;
	}
	/**
	 * @param codePostal the codePostal to set
	 */
	public void setCodePostal(int codePostal) {
		this.codePostal = codePostal;
	}
	/**
	 * @return the telephone
	 */
	public long getTelephone() {
		return telephone;
	}
	/**
	 * @param telephone the telephone to set
	 */
	public void setTelephone(long telephone) {
		this.telephone = telephone;
	}
	/**
	 * @param nom
	 * @param prenom
	 * @param adresse
	 * @param codePostal
	 * @param telephone
	 */
	public Personne(String nom, String prenom, String adresse, int codePostal,
			long telephone) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.codePostal = codePostal;
		this.telephone = telephone;
	}
	/**
	 * 
	 */
	public Personne() {
		super();
	}
	
	
}
