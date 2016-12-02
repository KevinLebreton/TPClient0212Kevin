package org.formation.dao;

import java.util.List;


import org.formation.model.CompteBancaire;

public interface IDaoCompte {

	public void createCompte(CompteBancaire compte);
	
	
	public CompteBancaire getComptebyNum(long numCompte);
	
	
	public List<CompteBancaire> getAllCompte();
	
	
	public void updateCompte(CompteBancaire compte);
	
	
	public void deleteCompteByNum(long numCompte);
	
}
