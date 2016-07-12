package fr.adaming.model;

import java.util.Date;
import java.util.List;

public class Agence {
	private String numero;
	private Date dateCreation;
	
	private Gerant gerant;

	private List<ConseillerClientele> conseillers;
}
