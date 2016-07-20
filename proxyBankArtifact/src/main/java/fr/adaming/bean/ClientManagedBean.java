package fr.adaming.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.adaming.exception.ExceptionNombreClient;
import fr.adaming.exception.ExceptionSolde;
import fr.adaming.model.Client;
import fr.adaming.model.CompteCourant;
import fr.adaming.model.CompteEpargne;
import fr.adaming.model.ConseillerClientele;
import fr.adaming.model.Gerant;
import fr.adaming.service.ClientServiceImpl;
import fr.adaming.service.IClientService;
import fr.adaming.service.ICompteService;
import fr.adaming.service.IConseillerService;
import fr.adaming.service.IGerantService;

@ManagedBean(name = "clientMB")
@SessionScoped
@Component
public class ClientManagedBean implements Serializable {
	private static final long serialVersionUID = 86L;

	private Client client;
	private boolean editMode = false;
	private boolean addCompteEpargne;
	private boolean addCompteCourant;
	private CompteCourant compteCourant;
	private ConseillerClientele conseiller;
	private Gerant gerant;
	private CompteEpargne compteEpargne;
	private List<Client> list = null;
	private String passwordConseiller = "CS";
	private String passwordGerant = "GR";
	private String nom;
	private String prenom;
	private String password;
	private float solde;
	private int idCompteEpargne1;
	private int idComptecourant1;
	private int idCompteEpargne2;
	private int idComptecourant2;
	private boolean sens;

	@ManagedProperty(value = "#{clientServiceBean}")
	// @Autowired
	IClientService clientService;

	@Autowired
	IConseillerService conseillerService;

	@Autowired
	IGerantService gerantService;
	
	@Autowired
	ICompteService compteService;

	private List<Client> listeClients;

	/**
	 * ctor vide
	 */
	public ClientManagedBean() {
		client = new Client();
	}

	public void reload() {
		setListeClients(clientService.getAllClients());
	}

	/**
	 * Pour créer le client à partir du formulaire
	 */
	public void ajouter() throws ExceptionNombreClient {
		if (editMode == false) {
			if (addCompteCourant != true) {
				compteCourant = null;
			}

			if (addCompteEpargne != true) {
				compteEpargne = null;
			}

			clientService
					.ajouterClient(1, client, compteCourant, compteEpargne);
			list = clientService.getClientsByConseiller(conseiller);
			client = new Client();
			compteCourant = new CompteCourant();
			compteEpargne = new CompteEpargne();
			conseiller = new ConseillerClientele();
		} else {
			clientService.modifierClient(client);
			list = clientService.getClientsByConseiller(conseiller);
			editMode = false;
			client = new Client();
		}
	}

	/**
	 * @return the conseillerService
	 */
	public IConseillerService getConseillerService() {
		return conseillerService;
	}

	/**
	 * @param conseillerService
	 *            the conseillerService to set
	 */
	public void setConseillerService(IConseillerService conseillerService) {
		this.conseillerService = conseillerService;
	}

	/**
	 * @return the clientService
	 */
	public IClientService getClientService() {
		return clientService;
	}

	/**
	 * @param clientService
	 *            the clientService to set
	 */
	public void setClientService(IClientService clientService) {
		this.clientService = clientService;
	}

	public void virementInterne() throws ExceptionSolde {
		clientService.virementInterne(solde, client,sens);
	}

	// public void virement() throws ExceptionSolde{
	// clientService.virement(solde, idComptecourant1, idCompteEpargne1,
	// idComptecourant2, idComptecourant2);}

	// public void getAllClients() {
	// this.listeClients=clientService.getAllClients();
	// }

	public List<Client> getAllClients() {
		return clientService.getAllClients();
	}

	public List<Client> getClientsByConseiller(ConseillerClientele conseiller) {
		return clientService.getClientsByConseiller(conseiller);
	}

	public void modifier() {
		clientService.modifierClient(client);
	}

	public void supprimerById() {
		clientService.supprimerClient(client.getId());
		// TODO supprimer comptes associes
	}

	public void supprimer() {
		clientService.supprimerClient(client);
	}

	public String isConseillerExistMB() {
		int verif = conseillerService.isExist(this.nom, this.prenom);
		if (verif == 1 && this.password.equals(this.passwordConseiller)) {
			return "succes";
		} else {
			return "echec";
		}
	}

//	public String isGerantExistMB() {
//		int verif = gerantService.isExist(this.nom, this.prenom);
//		if (verif == 1 && this.password.equals(this.passwordGerant)) {
//			return "succes";
//		} else {
//			return "echec";
//		}
//	}
	
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<Client> getListeClients() {
		return listeClients;
	}

	public void setListeClients(List<Client> listeClients) {
		this.listeClients = listeClients;
	}

	/**
	 * @return the editMode
	 */
	public boolean isEditMode() {
		return editMode;
	}

	/**
	 * @param editMode
	 *            the editMode to set
	 */
	public void setEditMode(boolean editMode) {
		this.editMode = editMode;
	}

	/**
	 * @return the addCompteEpargne
	 */
	public boolean isAddCompteEpargne() {
		return addCompteEpargne;
	}

	/**
	 * @param addCompteEpargne
	 *            the addCompteEpargne to set
	 */
	public void setAddCompteEpargne(boolean addCompteEpargne) {
		this.addCompteEpargne = addCompteEpargne;
	}

	/**
	 * @return the addCompteCourant
	 */
	public boolean isAddCompteCourant() {
		return addCompteCourant;
	}

	/**
	 * @param addCompteCourant
	 *            the addCompteCourant to set
	 */
	public void setAddCompteCourant(boolean addCompteCourant) {
		this.addCompteCourant = addCompteCourant;
	}

	/**
	 * @return the compteCourant
	 */
	public CompteCourant getCompteCourant() {
		return compteCourant;
	}

	/**
	 * @param compteCourant
	 *            the compteCourant to set
	 */
	public void setCompteCourant(CompteCourant compteCourant) {
		this.compteCourant = compteCourant;
	}

	/**
	 * @return the conseiller
	 */
	public ConseillerClientele getConseiller() {
		return conseiller;
	}

	/**
	 * @param conseiller
	 *            the conseiller to set
	 */
	public void setConseiller(ConseillerClientele conseiller) {
		this.conseiller = conseiller;
	}

	/**
	 * @return the gerant
	 */
	public Gerant getGerant() {
		return gerant;
	}

	/**
	 * @param gerant
	 *            the gerant to set
	 */
	public void setGerant(Gerant gerant) {
		this.gerant = gerant;
	}

	/**
	 * @return the gerantService
	 */
	public IGerantService getGerantService() {
		return gerantService;
	}

	/**
	 * @param gerantService
	 *            the gerantService to set
	 */
	public void setGerantService(IGerantService gerantService) {
		this.gerantService = gerantService;
	}

	/**
	 * @return the compteEpargne
	 */
	public CompteEpargne getCompteEpargne() {
		return compteEpargne;
	}

	/**
	 * @param compteEpargne
	 *            the compteEpargne to set
	 */
	public void setCompteEpargne(CompteEpargne compteEpargne) {
		this.compteEpargne = compteEpargne;
	}

	/**
	 * @return the list
	 */
	public List<Client> getList() {
		return list;
	}

	/**
	 * @param list
	 *            the list to set
	 */
	public void setList(List<Client> list) {
		this.list = list;
	}

	/**
	 * @return the passwordConseiller
	 */
	public String getPasswordConseiller() {
		return passwordConseiller;
	}

	/**
	 * @param passwordConseiller
	 *            the passwordConseiller to set
	 */
	public void setPasswordConseiller(String passwordConseiller) {
		this.passwordConseiller = passwordConseiller;
	}

	/**
	 * @return the passwordGerant
	 */
	public String getPasswordGerant() {
		return passwordGerant;
	}

	/**
	 * @param passwordGerant
	 *            the passwordGerant to set
	 */
	public void setPasswordGerant(String passwordGerant) {
		this.passwordGerant = passwordGerant;
	}

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom
	 *            the nom to set
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
	 * @param prenom
	 *            the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the solde
	 */
	public float getSolde() {
		return solde;
	}

	/**
	 * @param solde
	 *            the solde to set
	 */
	public void setSolde(float solde) {
		this.solde = solde;
	}

	/**
	 * @return the idCompteEpargne1
	 */
	public int getIdCompteEpargne1() {
		return idCompteEpargne1;
	}

	/**
	 * @param idCompteEpargne1
	 *            the idCompteEpargne1 to set
	 */
	public void setIdCompteEpargne1(int idCompteEpargne1) {
		this.idCompteEpargne1 = idCompteEpargne1;
	}

	/**
	 * @return the idComptecourant1
	 */
	public int getIdComptecourant1() {
		return idComptecourant1;
	}

	/**
	 * @param idComptecourant1
	 *            the idComptecourant1 to set
	 */
	public void setIdComptecourant1(int idComptecourant1) {
		this.idComptecourant1 = idComptecourant1;
	}

	/**
	 * @return the idCompteEpargne2
	 */
	public int getIdCompteEpargne2() {
		return idCompteEpargne2;
	}

	/**
	 * @param idCompteEpargne2
	 *            the idCompteEpargne2 to set
	 */
	public void setIdCompteEpargne2(int idCompteEpargne2) {
		this.idCompteEpargne2 = idCompteEpargne2;
	}

	/**
	 * @return the idComptecourant2
	 */
	public int getIdComptecourant2() {
		return idComptecourant2;
	}

	/**
	 * @param idComptecourant2
	 *            the idComptecourant2 to set
	 */
	public void setIdComptecourant2(int idComptecourant2) {
		this.idComptecourant2 = idComptecourant2;
	}

	/**
	 * @return the sens
	 */
	public boolean isSens() {
		return sens;
	}

	/**
	 * @param sens
	 *            the sens to set
	 */
	public void setSens(boolean sens) {
		this.sens = sens;
	}
	
	public String affComptes(Client client){
		setClient(client);
		setCompteCourant(client.getCompteCourant());
		setCompteEpargne(client.getCompteEpargne());
		
		return "affComptesClient";
	}
	public void loadComptes(){
		setClient(clientService.getClientById(client.getId()));
		setCompteCourant(client.getCompteCourant());
		setCompteEpargne(client.getCompteEpargne());
	}

}
