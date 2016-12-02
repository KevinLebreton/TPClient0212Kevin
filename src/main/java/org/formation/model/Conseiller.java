package org.formation.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="CONSEILLER")
@ManagedBean
@ApplicationScoped
public class Conseiller implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// Attributs
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long idCons;
	
	private String nom;
	private String prenom;
	private String login;
	private String password;
	
	@OneToMany(mappedBy="cons", cascade = {CascadeType.PERSIST}, fetch = FetchType.EAGER)
	private Set<Client> listClient = new HashSet<>();
	
	//Constructors
	public Conseiller() {
		super();
	}
	
	

	public Conseiller(String nom, String prenom, String login, String password) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.login = login;
		this.password = password;
	}



	// Getters and Setters
	public Long getIdCons() {
		return idCons;
	}

	public void setIdCons(Long idCons) {
		this.idCons = idCons;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Client> getListClient() {
		return listClient;
	}

	public void setListClient(Set<Client> listClient) {
		this.listClient = listClient;
	}

	// Methode 
	@Override
	public String toString() {
		return "Conseiller [idCons=" + idCons + ", nom=" + nom + ", prenom=" + prenom + ", login=" + login
				+ ", password=" + password + ", listClient=" + listClient + "]";
	}
	
	public void addClient(Client client){
		listClient.add(client);
		client.setCons(this);
	}
	
	
}
