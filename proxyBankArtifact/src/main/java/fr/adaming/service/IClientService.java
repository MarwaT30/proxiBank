package fr.adaming.service;

import java.util.List;

import fr.adaming.exception.ExceptionNombreClient;
import fr.adaming.model.Client;
import fr.adaming.model.CompteCourant;
import fr.adaming.model.CompteEpargne;
import fr.adaming.model.ConseillerClientele;

public interface IClientService {
	/**
	 * 
	 * @return tous les clients de la base
	 */
	public List<Client> getAllClients();

	/**
	 * 
	 * @param i
	 * @return les clients gérés par ce conseiller
	 */
	public List<Client> getClientsByConseiller(ConseillerClientele conseiller);

	/**
	 * ajoute le client dans la base
	 * 
	 * @param client
	 * @return 1 si OK
	 */
	//public void ajouterClient(Client client)throws ExceptionNombreClient;
	public void ajouterClient(int idConseiller,Client client,CompteCourant compteCourant, CompteEpargne compteEpargne) throws ExceptionNombreClient;
	/**
	 * 
	 * @param client
	 *            le client modifié
	 * @return
	 */
	public void modifierClient(Client client);

	/**
	 * supprime par ID
	 * 
	 * @param id
	 *            l'id du client à supprimer
	 * @return
	 */
	public void supprimerClient(int id);

	/**
	 * supprimer par Client
	 * 
	 * @param client
	 *            le client avec l'ID à suppriemr
	 * @return
	 */
	public void supprimerClient(Client client);
}
