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
import fr.adaming.model.ConseillerClientele;
import fr.adaming.service.ClientServiceImpl;
import fr.adaming.service.IClientService;

@ManagedBean(name = "clientMB")
@SessionScoped
@Component
public class ClientManagedBean implements Serializable {
	private static final long serialVersionUID = 86L;
	
	
	private Client client;

	
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
		System.out.println(client.getNom());

		clientService.ajouterClient(client);
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

}
