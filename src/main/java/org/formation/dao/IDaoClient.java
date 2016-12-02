package org.formation.dao;

import java.util.List;

import org.formation.model.Client;



public interface IDaoClient {

	public void createClient(Client c);
	
		
	public Client getClientById(Long i);
	
	
	public List<Client> getAllClient();
	
	
	public void updateClient(Client c);
	
	
	public void deleteClientById(Long i);
}
