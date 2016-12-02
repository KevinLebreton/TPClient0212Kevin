package org.formation.dao;

import java.util.List;

import org.formation.model.Conseiller;

public interface IDaoConseiller {

	public void createConseiller(Conseiller cons);
	
	
	public Conseiller getConseillerByLogin(String login);
	
	
	public List<Conseiller> getAllConseiller();
	
	
	public void updateConseillert(Conseiller cons);
	
	
	public void deleteConseillerById(Long idCons);
	
}
