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
import org.formation.model.CompteBancaire;
import org.formation.service.IServiceClient;
import org.formation.service.ServiceClient;

/**
 * @author Audrey, Kevin
 * Methodes du conseiller pour agir sur le compte
 *
 */
@ManagedBean
public class CompteController {

	@EJB
	private ServiceClient serviceClient;
	
	private double montant = 0.0;
	private Long cptcrenum = 0L;
	private Long numCompte;
	
	private List<CompteBancaire> comptes = new ArrayList<>();

	public List<CompteBancaire> getComptes() {
		if(numCompte!=null){
			comptes = filterComptes();
		}else{
		comptes = serviceClient.getComptes();
		}
		return comptes;
	}
	
	public Long getNumCompte() {
		return numCompte;
	}

	public void setNumCompte(Long numCompte) {
		this.numCompte = numCompte;
	}

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

	public Long getCptcrenum() {
		return cptcrenum;
	}

	public void setCptcrenum(Long cptcrenum) {
		this.cptcrenum = cptcrenum;
	
	}
	
	

    private List<CompteBancaire> filterComptes(){
    	List<CompteBancaire> ret = new ArrayList<>();
    	for(CompteBancaire t:serviceClient.getComptes()){
    		if(t.getClient().getIdClient() == numCompte){
    			ret.add(t);
    		}
    	}
    	return ret;
    }
	
	private List<CompteBancaire> comptesExceptOne = new ArrayList<>();

	public List<CompteBancaire> getComptesExceptOne() {
		comptes = serviceClient.getComptes();
		return comptesExceptOne;
	}
	
	public String chargerClientCompte(Long idClient) {
		Client client = serviceClient.readClientById(idClient);
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();

		Map<String, Object> sessionMap = externalContext.getSessionMap();
		sessionMap.put("cl", client);
		return "creationCompte";
	}

	public String chargerClientComptes(Long idClient) {
		Client client = serviceClient.readClientById(idClient);
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();

		Map<String, Object> sessionMap = externalContext.getSessionMap();
		sessionMap.put("cl", client);
		return "listeCompte";
	}

	public String supprimerCompteByNum(Long numCompte) {
		serviceClient.supprimerCompteByNum(numCompte);
		return "listeCompte";
	}

	public String chargerCompte(Long numCompte) {
		CompteBancaire cpte = serviceClient.readCompte(numCompte);
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		Map<String, Object> sessionMap = externalContext.getSessionMap();
		sessionMap.put("cpt", cpte);
		return "virement";
	}

	public String creerCompteClient(Long idClient, CompteBancaire compte) {
		serviceClient.creerCompteForClient(idClient, compte);
		return "listeCompte";
	}
	
	public String faireVirement(Long numDeb, Long numCre, double vir) {
		serviceClient.faireVirement(numDeb, numCre, vir);
		return "listeCompte";
	}
}
