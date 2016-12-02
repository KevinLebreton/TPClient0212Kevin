package org.formation.service;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import org.formation.dao.DaoConseillerSQL;
import org.formation.model.Conseiller;

@LocalBean
@Stateless
public class ServiceConseiller implements IServiceConseiller, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1487897879561L;
	@EJB
	DaoConseillerSQL daoCons;
	
	@Override
	public void enregistrerConseiller(Conseiller cons) {
		daoCons.createConseiller(cons);
		
	}

	@Override
	public Conseiller readConsByLogin(String login) {
		return daoCons.getConseillerByLogin(login);
	}

	@Override
	public List<Conseiller> listCons() {
		return daoCons.getAllConseiller();
	}

	@Override
	public void modifierConseiller(Conseiller cons) {
		daoCons.updateConseillert(cons);
		
	}

	@Override
	public void supprimerConseillerById(Long idCons) {
		daoCons.deleteConseillerById(idCons);
		
	}

	
}
