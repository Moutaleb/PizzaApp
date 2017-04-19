package fr.pizzeria.console;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import fr.pizzeria.dao.PizzaDao;
import fr.pizzeria.dao.PizzaDaoFichier;
import fr.pizzeria.dao.Stockage;
import fr.pizzeria.ihm.AjouterPizzaOptionMenu;
import fr.pizzeria.ihm.ListerPizzaOptionMenu;
import fr.pizzeria.ihm.MettreAJourPizzaOptionMenu;
import fr.pizzeria.ihm.SupprimmerUnePizzaOptionMenu;

public class PizzeriaAdminConsoleApp {

	public static void main(String[] args) {
		
		int saisie=0;
		
		
		// Création de tableau de 50 lignes et 3 colonnes.
		//String [][] pizzas = new String[50][3];
		// Initialisation du tableau des pizzas.
		/**
		pizzas[0] = new String[] {"PEP","Pépéroni","12.50"};
		pizzas[1] = new String[] {"MAR","Margherita","14.00"};
		pizzas[2] = new String[] {"REI","La Reine","11.50"};
		pizzas[3] = new String[] {"FRO","La 4 fromages","12.00"};
		pizzas[4] = new String[] {"CAN","La cannibale","12.50"};
		pizzas[5] = new String[] {"SAV","La savoyarde","13.00"};
		pizzas[6] = new String[] {"ORI","L'orientale","13.50"};
		pizzas[7] = new String[] {"IND","L'indienne","14.00"}; */
		
		
		List<Pizza> pizzas = new ArrayList<>();
		pizzas.add(new Pizza ("PEP","Péperoni",12.50));
		pizzas.add(new Pizza ("MAR","Margherita",14.00));
		pizzas.add(new Pizza ("REI","La Reine",11.50));
		pizzas.add(new Pizza ("FRO","La 4 fromages",12.00));
		pizzas.add(new Pizza ("CAN","La cannibale",12.50));
		pizzas.add(new Pizza ("SAV","La savoyarde",13.00));
		pizzas.add(new Pizza ("ORI","L'orientale",13.50));
		pizzas.add(new Pizza ("IND","L'indienne",14.00));
		
		Stockage dao = new PizzaDao(pizzas);
	
		//Stockage dao = new PizzaDaoFichier();
		
		while (saisie!=99){
		
			// Affichage du menu des pizzas.
			System.out.println("***** Pizzeria Administration *****");
			System.out.println("1. Lister les pizzas");
			System.out.println("2. Ajouter une nouvelle pizza");
			System.out.println("3. Mettre à jour une pizza");
			System.out.println("4. Supprimer une pizza");
			System.out.println("99. Sortir");
			
			
			
			// ce que l'utilisateur va saisir va dans saisie.
			Scanner question = new Scanner (System.in);
			saisie = question.nextInt();
			
			if (saisie == 1)
			{
				ListerPizzaOptionMenu listage = new ListerPizzaOptionMenu(dao);
				listage.execute();
			}
			
			if (saisie == 2)
			{
				
				AjouterPizzaOptionMenu ajouterPizza = new AjouterPizzaOptionMenu(dao);
				ajouterPizza.execute();				
			}
			
			if (saisie == 3)
			{
				
				MettreAJourPizzaOptionMenu mettreajourPizza = new MettreAJourPizzaOptionMenu(dao);
				mettreajourPizza.execute();
				
			
			}
			
			if (saisie == 4)
			{
				SupprimmerUnePizzaOptionMenu supprimerPizza = new SupprimmerUnePizzaOptionMenu(dao);
				supprimerPizza.execute();
				
			}
			
			if (saisie == 99)
			{
				System.out.println("AUREVOIR");
			}
			
			
		
		}
		
						
		
		

	}
	
	

}
