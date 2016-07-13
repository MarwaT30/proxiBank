package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Client;
import fr.adaming.model.ConseillerClientele;

public interface IClientService {
	/**
	 * 
	 * @return tous les clients de la base
	 */
	public List<Client> getAllClients();

	/**
	 * 
	 * @param conseiller
	 * @return les clients gérés par ce conseiller
	 */
	public List<Client> getClientsByConseiller(ConseillerClientele conseiller);

	/**
	 * ajoute le client dans la base
	 * 
	 * @param client
	 * @return 1 si OK
	 */
	public int ajouterClient(Client client);

	/**
	 * 
	 * @param client
	 *            le client modifié
	 * @return
	 */
	public int modifierClient(Client client);

	/**
	 * supprime par ID
	 * 
	 * @param id
	 *            l'id du client à supprimer
	 * @return
	 */
	public int supprimerClient(int id);

	/**
	 * supprimer par Client
	 * 
	 * @param client
	 *            le client avec l'ID à suppriemr
	 * @return
	 */
	public int supprimerClient(Client client);
}
