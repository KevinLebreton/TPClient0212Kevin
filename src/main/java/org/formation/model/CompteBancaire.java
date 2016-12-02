package org.formation.model;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="COMPTEBANCAIRE")
@ManagedBean
@SessionScoped
public class CompteBancaire implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long numCompte;

	private double solde;

	@ManyToOne(cascade = { CascadeType.PERSIST })
	@JoinColumn(name = "client_id")
	private Client client;

	private TypeCompte typeCompte;

	// Constructors
	public CompteBancaire() {
		super();
	}

	
	
	public CompteBancaire(long numCompte, double solde, Client client, TypeCompte typeCompte) {
		super();
		this.numCompte = numCompte;
		this.solde = solde;
		this.client = client;
		this.typeCompte = typeCompte;
	}



	public CompteBancaire(double solde, Client client, TypeCompte typeCompte) {
		super();
		this.solde = solde;
		this.client = client;
		this.typeCompte = typeCompte;
	}



	public CompteBancaire(double solde, TypeCompte typeCompte) {
		super();
		this.solde = solde;
		this.typeCompte = typeCompte;
	}



	// Getters and Setters
	public long getNumCompte() {
		return numCompte;
	}

	public void setNumCompte(long numCompte) {
		this.numCompte = numCompte;
	}

	public double getSolde() {
		return solde;
	}

	public void setSolde(double solde) {
		this.solde = solde;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public TypeCompte getTypeCompte() {
		return typeCompte;
	}

	public void setTypeCompte(TypeCompte typeCompte) {
		this.typeCompte = typeCompte;
	}



	@Override
	public String toString() {
		return "CompteBancaire [numCompte=" + numCompte + ", solde=" + solde + ", client=" + client + ", typeCompte="
				+ typeCompte + "]";
	}

	
	
}
