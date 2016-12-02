package org.formation.service;

import java.util.List;

import org.formation.model.Client;
import org.formation.model.CompteBancaire;

public interface IServiceClient {

	void enregistrerClient(Client c);

	Client readClientById(Long idClient);

	List<Client> getClients();

	void modifierClient(Client c);

	void supprimerClientById(Long IdClient);
	
	void faireVirement(Long numDeb, Long numCre, double vir);
	
	public List<CompteBancaire> getComptes();
	
	public void supprimerCompteByNum(Long numCompte);
	
	CompteBancaire readCompte(Long numCompte);
	
	public void creerCompteForClient(Long idCli, CompteBancaire compte);
}