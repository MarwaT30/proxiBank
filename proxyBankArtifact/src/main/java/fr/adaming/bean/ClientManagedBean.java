package fr.adaming.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import fr.adaming.model.Client;
import fr.adaming.service.ClientServiceImpl;
import fr.adaming.service.IClientService;

@ManagedBean(name = "clientMB")
@SessionScoped
public class ClientManagedBean implements Serializable {
	private static final long serialVersionUID = 615713187L;

	private Client client;
	
	IClientService clientService = new ClientServiceImpl();
	
	private List<Client> listeClients;
	
	public void reload(){
		setListeClients(clientService.getAllClients());
	}

	/**
	 * Pour créer le client à partir du formulaire
	 */
	public void ajouter() {
		System.out.println(client.getNom());
		
		clientService.ajouterClient(client);
	}

	/**
	 * ctor vide
	 */
	public ClientManagedBean() {
		super();
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
