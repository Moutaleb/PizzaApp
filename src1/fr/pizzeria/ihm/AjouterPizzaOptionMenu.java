package fr.pizzeria.ihm;

import java.util.Scanner;

import fr.pizzeria.console.Pizza;
import fr.pizzeria.dao.Stockage;
import fr.pizzeria.exception.SavePizzaException;

public class AjouterPizzaOptionMenu extends OptionMenu {

	
	public AjouterPizzaOptionMenu (Stockage pizzaDao) {
		super(pizzaDao);
	}
	
	
	public boolean execute(){
		System.out.println("2. Ajouter une nouvelle pizza");
		System.out.println("Veuillez saisir le code:");
		
		
		
		Scanner question = new Scanner (System.in);
		
		// Reprise de ce qui va être saisie et affecté dans code.
		String code = question.next();
		System.out.println("Veuillez saisir le nom (sans espace):");
		String libelle = question.next();
		System.out.println("Veuillez saisir le prix");
		double prix = question.nextDouble();
		
		// Création d'un nouveau tableau qui va être dans la case 8.
		Pizza pizza = new Pizza (code,libelle,prix);
		
		try {
			pizzaDao.saveNewPizza(pizza);
		} catch (SavePizzaException e) {
			// TODO Auto-generated catch block
			System.out.println("La pizza existe deja !");
		
		}

		
		return true;
	}
}
