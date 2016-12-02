package org.formation.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import org.formation.model.Client;
import org.formation.service.ServiceClient;

/**
 * @author Audrey, Kevin
 * Classe des methodes du conseiller pour agir sur le client
 *
 */
@ManagedBean(name = "clientController")

public class ClientController {

	@EJB
	private ServiceClient serviceClient;

	private List<Client> clients = new ArrayList<>();

	public String goToCreateClient() {
		return "ajoutClient";
	}
	
	public List<Client> getClients() {
		clients = serviceClient.getClients();
		return clients;
	}

	public String enregistrerClient(Client c) {
		serviceClient.enregistrerClient(c);
		return "listeClient";
	}

	public String modifierClient(Client c) {
		serviceClient.modifierClient(c);
		return "listeClient";
	}

	public String supprimerClientById(Long id) {
		serviceClient.supprimerClientById(id);
		return "listeClient";
	}

	public String readClientById(Long id) {
		serviceClient.readClientById(id);
		return "modifierClient";
	}

	public String chargerClientModification(Long idClient) {
		Client client = serviceClient.readClientById(idClient);
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();

		Map<String, Object> sessionMap = externalContext.getSessionMap();
		sessionMap.put("cl", client);
		return "modifierClient";
	}

}
