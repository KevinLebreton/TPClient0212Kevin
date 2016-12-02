package org.formation.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;

import org.formation.model.Client;
import org.formation.model.CompteBancaire;

@LocalBean
@Stateless
public class DaoCompteSQL implements IDaoCompte, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1564561674453L;
	/**
	 * DAO compte utilisant les methodes CRUD permettant la persistance en base de données
	 */
	
	@PersistenceUnit
	private static EntityManagerFactory emf;
	
	@Override
	public void createCompte(CompteBancaire compte) {
		EntityManager em = emf.createEntityManager();
		em.persist(compte);
	}

	@Override
	public CompteBancaire getComptebyNum(long numCompte) {
		EntityManager em = emf.createEntityManager();
		CompteBancaire compte = null;
		compte = em.find(CompteBancaire.class, numCompte);
		return compte;
	}

	@Override
	public List<CompteBancaire> getAllCompte() {
		EntityManager em = emf.createEntityManager();
		List<CompteBancaire> listCompte = new ArrayList<>();
		TypedQuery<CompteBancaire> query = em.createQuery("from CompteBancaire", CompteBancaire.class);
		listCompte = query.getResultList();
		return listCompte;

	}

	@Override
	public void updateCompte(CompteBancaire compte) {
		EntityManager em = emf.createEntityManager();
		em.merge(compte);	
	}

	@Override
	public void deleteCompteByNum(long numCompte) {
		EntityManager em = emf.createEntityManager();
		CompteBancaire compte = null;
		compte = em.find(CompteBancaire.class, numCompte);
		em.remove(compte);	
	}

}
