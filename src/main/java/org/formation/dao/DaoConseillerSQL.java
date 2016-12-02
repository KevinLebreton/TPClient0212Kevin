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

import org.formation.model.Conseiller;

@LocalBean
@Stateless
public class DaoConseillerSQL implements IDaoConseiller, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1189454754894L;
	/**
	 * DAO conseiller utilisant les methodes CRUD permettant la persistance en base de données
	 */
	
	@PersistenceUnit
	private static EntityManagerFactory emf;
	
	@Override
	public void createConseiller(Conseiller cons) {
		EntityManager em = emf.createEntityManager();
			em.persist(cons);
	}

	@Override
	public Conseiller getConseillerByLogin(String login) {
		EntityManager em = emf.createEntityManager();
		Conseiller conseiller = null;
		conseiller = em.find(Conseiller.class, login);
		return conseiller;

	}

	@Override
	public List<Conseiller> getAllConseiller() {
		EntityManager em = emf.createEntityManager();
		List<Conseiller> listConseiller = new ArrayList<>();
		TypedQuery<Conseiller> query = em.createQuery("from Conseiller", Conseiller.class);
		listConseiller = query.getResultList();
		return listConseiller;
	}

	@Override
	public void updateConseillert(Conseiller cons) {
		EntityManager em = emf.createEntityManager();
		em.merge(cons);
	}

	@Override
	public void deleteConseillerById(Long idCons) {
		EntityManager em = emf.createEntityManager();
		Conseiller conseiller = null;
		conseiller = em.find(Conseiller.class, idCons);
		em.remove(conseiller);

	}
	
}
