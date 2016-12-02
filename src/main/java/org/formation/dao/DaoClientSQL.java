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
import org.formation.service.BDAccess;

@LocalBean
@Stateless
public class DaoClientSQL implements IDaoClient, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 115614564845158L;
	/**
	 * DAO client utilisant les methodes CRUD permettant la persistance en base de données
	 */
	
	@PersistenceUnit
	private static EntityManagerFactory emf;

	@Override
	public void createClient(Client c) {
		EntityManager em = emf.createEntityManager();
		em.persist(c);
	}

	@Override
	public Client getClientById(Long i) {
		EntityManager em = emf.createEntityManager();
		Client client = null;
		client = em.find(Client.class, i);
		return client;
	}

	@Override
	public List<Client> getAllClient() {
		EntityManager em = emf.createEntityManager();
		List<Client> listClient = new ArrayList<>();
		TypedQuery<Client> query = em.createQuery("from Client", Client.class);
		listClient = query.getResultList();
		return listClient;
	}

	@Override
	public void updateClient(Client c) {
		EntityManager em = emf.createEntityManager();
			em.merge(c);
	}

	@Override
	public void deleteClientById(Long idClient) {
		EntityManager em = emf.createEntityManager();
		Client c= null;
		c = em.find(Client.class, idClient);
		em.remove(c);
	}

}
