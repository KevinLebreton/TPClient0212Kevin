package org.formation.service;

import java.util.List;

import org.formation.model.Conseiller;

public interface IServiceConseiller {

	void enregistrerConseiller(Conseiller cons);
	
	Conseiller readConsByLogin(String login);
	
	List<Conseiller> listCons();
	
	void modifierConseiller(Conseiller cons);
	
	void supprimerConseillerById(Long idCons);
	
}
