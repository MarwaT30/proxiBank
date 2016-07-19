package fr.adaming.bean;

import java.io.Serializable;
import java.util.List;













import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;






import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.adaming.exception.ExceptionNombreClient;
import fr.adaming.model.Client;
import fr.adaming.model.CompteCourant;
import fr.adaming.model.CompteEpargne;
import fr.adaming.model.ConseillerClientele;
import fr.adaming.service.ClientServiceImpl;
import fr.adaming.service.IClientService;

@ManagedBean(name = "clientMB")
@SessionScoped
@Component
public class ClientManagedBean implements Serializable {
	private static final long serialVersionUID = 86L;
	
	
	private Client client;
	private boolean editMode=false;
	private boolean addCompteEpargne;
	private boolean addCompteCourant;
	private CompteCourant compteCourant;
	private ConseillerClientele conseiller;
	private CompteEpargne compteEpargne;
	private List<Client> list =null;

	@ManagedProperty(value="#{clientServiceBean}")
	//@Autowired
	IClientService clientService;
	
	
	private List<Client> listeClients;

	/**
	 * ctor vide
	 */
	public ClientManagedBean() {
		client=new Client();
	}
	
	
	
	public void reload() {
		setListeClients(clientService.getAllClients());
	}

	/**
	 * Pour créer le client à partir du formulaire
	 */
	public void ajouter() throws ExceptionNombreClient{
		if (editMode == false) {
			if (addCompteCourant != true) {
				compteCourant = null;
			}

			if (addCompteEpargne != true) {
				compteEpargne = null;
			}
//conseiller.getId()
			clientService.ajouterClient(1, client, compteCourant,compteEpargne);
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
	 * @return the clientService
	 */
	public IClientService getClientService() {
		return clientService;
	}



	/**
	 * @param clientService the clientService to set
	 */
	public void setClientService(IClientService clientService) {
		this.clientService = clientService;
	}



	public void getAllClients() {
		this.listeClients=clientService.getAllClients();
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
	 * @param editMode the editMode to set
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
	 * @param addCompteEpargne the addCompteEpargne to set
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
	 * @param addCompteCourant the addCompteCourant to set
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
	 * @param compteCourant the compteCourant to set
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
	 * @param conseiller the conseiller to set
	 */
	public void setConseiller(ConseillerClientele conseiller) {
		this.conseiller = conseiller;
	}



	/**
	 * @return the compteEpargne
	 */
	public CompteEpargne getCompteEpargne() {
		return compteEpargne;
	}



	/**
	 * @param compteEpargne the compteEpargne to set
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
	 * @param list the list to set
	 */
	public void setList(List<Client> list) {
		this.list = list;
	}
	
	

}
