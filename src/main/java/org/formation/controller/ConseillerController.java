package org.formation.controller;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.formation.model.Conseiller;
import org.formation.service.ServiceConseiller;

/**
 * @author Audrey, Kevin
 * Methode du conseiller pour se connecter et se deconnecter
 *
 */
@ManagedBean
public class ConseillerController {

	@EJB
	private ServiceConseiller servcons;

	private List<Conseiller> listCons = new ArrayList<>();

	public List<Conseiller> getConseillers() {
		listCons = servcons.listCons();
		return listCons;
	}

	public String connectionCons(Conseiller conseiller) {

		List<Conseiller> conseillers = servcons.listCons();
		for (Conseiller cons : conseillers) {
			if (conseiller.getLogin().equals(cons.getLogin()) && conseiller.getPassword().equals(cons.getPassword())) {
				return "listeClient";
			}
		}
		return "";

	}

	public String connection(Conseiller conseiller) {
		if (conseiller.getLogin().equals("abc") && conseiller.getPassword().equals("123")) {
			return "listeClient";
		}
		return"";

	}

	public String deconnection() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		session.removeAttribute("loggedCons");
		return "index";
	}

}
