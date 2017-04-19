package fr.pizzeria.console;

import fr.pizzeria.dao.DaoFactory;
import fr.pizzeria.dao.DaoFichierFactory;
import fr.pizzeria.dao.DaoMemoireFactory;
import fr.pizzeria.dao.GetDao;
import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.dao.PizzaDaoImplTableau;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.ihm.*;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

/**
 * Console d'administration d'une pizzeria
 * 
 * @author Abdel
 *
 * @tout droits reservés à Abdel.
 */
public class AdminConsoleApp {

	
	/*
	AdminConsoleApp console = new AdminConsoleApp();
	AdminConsoleApp console1 = new AdminConsoleApp();
	AdminConsoleApp consolee1 = new AdminConsoleApp();
	AdminConsoleApp consolee2 = new AdminConsoleApp();
	*/
	

	/**
	 * Application principale
	 * 
	 * @param Pas
	 *            de parametres requis
	 */
	public static void main(String args[]) {
		
//		PersonalScanner scaner
		
		
		
		


		DaoFactory daofactory = new DaoMemoireFactory();
		
		GetDao.set(daofactory.getPizzaDao());
		IPizzaDao dao = GetDao.get();

		try {
			dao.saveNewPizza(new Pizza("PEP", "Peproni", 12.50F, CategoriePizza.VIANDE));
			dao.saveNewPizza(new Pizza("MAR", "Margherita", 14F, CategoriePizza.SANS_VIANDE));
			dao.saveNewPizza(new Pizza("REI", "Reine", 11.50F, CategoriePizza.VIANDE));
			dao.saveNewPizza(new Pizza("FRO", "Fromage", 12F, CategoriePizza.SANS_VIANDE));
			dao.saveNewPizza(new Pizza("CAN", "La Canibale", 12.50F, CategoriePizza.VIANDE));
			dao.saveNewPizza(new Pizza("SAV", "Savoyarde", 13F, CategoriePizza.VIANDE));
			dao.saveNewPizza(new Pizza("ORI", "Orientale", 13.50F, CategoriePizza.VIANDE));
			dao.saveNewPizza(new Pizza("IND", "Indienne", 14F, CategoriePizza.VIANDE));
		} catch (SavePizzaException e) {
			System.err.println("ERREUR: initialisation des pizzas");
		}

		
		

		Menu menu = new Menu();
		menu.setTitre("\n******** Pizerria Administration ********");
		menu.ajouterAction(new ListerPizzasOptionMenu("Lister les Pizzas"));
		menu.ajouterAction(new NouvellePizzaOptionMenu("Ajouter une pizza"));
		menu.ajouterAction(new ModifierPizzaOptionMenu("Modifier une pizza"));
		menu.ajouterAction(new SupprimerPizzaOptionMenu("Supprimer une pizza"));
		menu.ajouterAction(99, new QuitterOptionMenu("Quitter"));
		menu.setFin("*****************************************");


		
		
		
		boolean quitter = false;
		while (!quitter) {

			menu.afficher();
			

			int input;
			input = PersonalScanner.askComande();

			if (!menu.execute(input)) {
				quitter = true;
				System.out.println("Bye bye :)");
			}
		}
	}
}
/*
 * switch (input) { case 1:{ afficherListe(); break; }
 * 
 * 
 * case 2: { System.out.println("2.  Ajouter une nouvelle pizza"); int i = 0;
 * while (i < MAX_SIZE && pizzaList[i] != null) { i++; } String code, nom;
 * double prix;
 * 
 * System.out.println("Entree code pizza"); code = inputScanner.next();
 * System.out.println("Entree nom pizza"); nom = inputScanner.next();
 * System.out.println("Entree prix pizza"); prix = inputScanner.nextDouble();
 * pizzaList[i] = new Pizza(indiceRef++, code, nom, prix); break; }
 * 
 * 
 * 
 * 
 * case 3: { System.out.println("3.  Mettre � jour une pizza");
 * afficherListe();
 * 
 * String code, nom; double prix; int indice;
 * 
 * System.out.println("Selectionner l'indice"); indice = inputScanner.nextInt();
 * if (indice != 99) { System.out.println("Entree code pizza"); code =
 * inputScanner.next(); System.out.println("Entree nom pizza"); nom =
 * inputScanner.next(); System.out.println("Entree prix pizza"); prix =
 * inputScanner.nextDouble();
 * 
 * pizzaList[indice].setCode(code); pizzaList[indice].setNom(nom);
 * pizzaList[indice].setPrix(prix); } break; }
 * 
 * 
 * 
 * 
 * case 4: { System.out.println("4.  Supprimer une pizza");
 * 
 * int indice; System.out.println("Indice a supprimer"); indice =
 * inputScanner.nextInt(); if (indice != 99) { int indiceCopie = 0; Pizza[]
 * pizzaTmp = new Pizza[MAX_SIZE]; for (int i = 0; i < MAX_SIZE; i++) { if
 * (pizzaList[i] != null && i != indice) { // recopier la pizza
 * pizzaTmp[indiceCopie] = pizzaList[i]; indiceCopie++; } }
 * 
 * pizzaList = pizzaTmp; } break; }
 * 
 * 
 * 
 * 
 * case 99: { System.out.println("99. Sortir"); quiter = true; break; }
 * 
 * default: { System.out.println("Entree incorecte"); }
 * 
 * } }
 * 
 * //
 */
// mainScaner.close();
