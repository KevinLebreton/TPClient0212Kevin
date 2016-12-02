package org.formation.service;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import org.formation.dao.DaoClientSQL;
import org.formation.dao.DaoCompteSQL;
import org.formation.dao.IDaoCompte;
import org.formation.model.Client;
import org.formation.model.CompteBancaire;

@LocalBean
@Stateless
public class ServiceClient implements IServiceClient, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1158647516785354L;

	/**
	 * Classe des methodes du conseiller pour agir sur le client
	 */
	@EJB
	private DaoClientSQL daoClient;
	
	@EJB
	private DaoCompteSQL daoCompte;
	
	/**Méthodes Client*/
	/* (non-Javadoc)
	 * @see org.formation.service.IServiceClient#enregistrerClient(org.formation.model.Client)
	 */
	@Override
	public void enregistrerClient(Client c){
		daoClient.createClient(c);
	}
	
	/* (non-Javadoc)
	 * @see org.formation.service.IServiceClient#readClientById(int)
	 */
	@Override
	public Client readClientById(Long idClient){
		return daoClient.getClientById(idClient);
	}
	
	
	/* (non-Javadoc)
	 * @see org.formation.service.IServiceClient#ListClient()
	 */
	@Override
	public List<Client> getClients(){
		return daoClient.getAllClient();
		
	}
	
	/* (non-Javadoc)
	 * @see org.formation.service.IServiceClient#modifierClient(org.formation.model.Client)
	 */
	@Override
	public void modifierClient(Client c){
		daoClient.updateClient(c);
	}
	
	/* (non-Javadoc)
	 * @see org.formation.service.IServiceClient#supprimerClientById(int)
	 */
	@Override
	public void supprimerClientById(Long IdClient){
		daoClient.deleteClientById(IdClient);
	}

	
	/**Méthode virement*/
	@Override
	public void faireVirement(Long numDeb, Long numCre, double vir) {
		// TODO Auto-generated method stub
		CompteBancaire cb1 = daoCompte.getComptebyNum(numDeb);
		CompteBancaire cb2 = daoCompte.getComptebyNum(numCre);
		double s1 = cb1.getSolde();
		double s2 = cb2.getSolde();
		cb1.setSolde(s1 - vir);
		cb2.setSolde(s2 + vir);
		daoCompte.updateCompte(cb1);
		daoCompte.updateCompte(cb2);
	}

	/**Méthodes Comptes*/
	
	
	public List<CompteBancaire> getComptes(){
		return daoCompte.getAllCompte();
	}
	
	public void supprimerCompteByNum(Long numCompte){
		CompteBancaire c = daoCompte.getComptebyNum(numCompte);
		c.setClient(null);
		daoCompte.updateCompte(c);
		daoCompte.deleteCompteByNum(numCompte);
	}
	
	public CompteBancaire readCompte(Long numCompte){
		return daoCompte.getComptebyNum(numCompte);
	}
	
	public void creerCompteForClient(Long idCli, CompteBancaire compte){
		Client client = daoClient.getClientById(idCli);
		//daoCompte.createCompte(compte);
		client.addCompte(compte);
		daoCompte.updateCompte(compte);
	}
	
	
	
}


