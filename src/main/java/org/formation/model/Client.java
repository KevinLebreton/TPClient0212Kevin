package org.formation.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.faces.bean.ManagedBean;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="CLIENT")
@ManagedBean
public class Client implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// Attributs
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idClient;

	private String nom;
	private String prenom;
	private String adresse;
	private int codePostal;
	private String ville;
	private String telephone;
	private String email;

	@ManyToOne(cascade = {CascadeType.PERSIST})
	@JoinColumn(name="conseiller_id")
	private Conseiller cons;

	@OneToMany(mappedBy="client", cascade = {CascadeType.PERSIST}, fetch = FetchType.EAGER)
	private Set<CompteBancaire> comptes = new HashSet<>();

	// Constructors
	public Client() {
		super();
	}

	public Client(Long idClient, String nom, String prenom, String adresse, int codePostal, String ville,
			String telephone, String email) {
		super();
		this.idClient = idClient;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.codePostal = codePostal;
		this.ville = ville;
		this.telephone = telephone;
		this.email = email;

	}

	public Client(String nom, String prenom, String adresse, int codePostal, String ville, String telephone,
			String email) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.codePostal = codePostal;
		this.ville = ville;
		this.telephone = telephone;
		this.email = email;
	}
	
	

	public Client(String nom, String prenom, String adresse, int codePostal, String ville,
			String telephone, String email, Conseiller idCons) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.codePostal = codePostal;
		this.ville = ville;
		this.telephone = telephone;
		this.email = email;
		this.cons = idCons;
	}

	// Getters and Setters
	public Long getIdClient() {
		return idClient;
	}

	public void setIdClient(Long idClient) {
		this.idClient = idClient;
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

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public int getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(int codePostal) {
		this.codePostal = codePostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Conseiller getCons() {
		return cons;
	}

	public void setCons(Conseiller cons) {
		this.cons = cons;
	}

	// Methode toString
	@Override
	public String toString() {
		return "Client [idClient=" + idClient + ", nom=" + nom + ", prenom=" + prenom + ", adresse=" + adresse
				+ ", codePostal=" + codePostal + ", ville=" + ville + ", telephone=" + telephone + ", email=" + email
				+ ", idCons=" + cons + "]";
	}
	
	public Set<CompteBancaire> getComptes() {
		return comptes;
	}

	public void setComptes(Set<CompteBancaire> comptes) {
		this.comptes = comptes;
	}

	public void addCompte(CompteBancaire compte){
		comptes.add(compte);
		compte.setClient(this);
	}
	
}
