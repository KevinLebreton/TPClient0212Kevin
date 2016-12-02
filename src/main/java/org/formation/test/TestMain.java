package org.formation.test;

import org.formation.controller.ClientController;
import org.formation.model.Client;
import org.formation.model.CompteBancaire;
import org.formation.model.Conseiller;
import org.formation.model.TypeCompte;
import org.formation.service.IServiceClient;
import org.formation.service.IServiceConseiller;
import org.formation.service.ServiceClient;
import org.formation.service.ServiceConseiller;

public class TestMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		IServiceClient serv = new ServiceClient();
		IServiceConseiller servcons = new ServiceConseiller();
		ClientController ccl = new ClientController();

//		System.out.println(ccl.getClients());
//		Conseiller cons1 = new Conseiller("Dylan", "Bob", "bob", "dylan");
//		Conseiller cons2 = new Conseiller("Rabbit", "Roger", "roger", "rabbit");
//
//		Client client1 = new Client("Lebreton", "Kevin", "avenue de la gare", 78180, "Montigny", "0625489655",
//				"kevin@gmail.com", cons1);
//
//		Client client2 = new Client("Gambade", "Audrey", "Rue du moulin", 78180, "Montigny", "0625489655",
//				"audrey.gambade@hotmail.Fr", cons1);
//
//		cons1.addClient(client1);
//		cons1.addClient(client2);
//
//		servcons.enregistrerConseiller(cons1);
//		servcons.enregistrerConseiller(cons2);
//
//		servcons.supprimerConseillerById(1);

//		CompteBancaire compte1 = new CompteBancaire(500, TypeCompte.EPARGNE);
//		CompteBancaire compte2 = new CompteBancaire(1000, TypeCompte.COURANT);
//		
//		serv.faireVirement(compte1, compte2, 100);
//		
//		System.out.println(compte1);
//		System.out.println(compte2);
		
		// System.out.println(serv.readClientById(1));

		// System.out.println(serv.ListClient());

		// String nom = "Girout";
		//
		// Client c = null;
		// c.setNom(nom);
		//
		// serv.modifierClient(c);
		//
		// System.out.println(c);

		// serv.supprimerClientById(2);

	}

}
