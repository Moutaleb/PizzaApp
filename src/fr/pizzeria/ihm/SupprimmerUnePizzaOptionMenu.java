package fr.pizzeria.ihm;

import java.util.Scanner;

import fr.pizzeria.console.Pizza;
import fr.pizzeria.dao.Stockage;
import fr.pizzeria.exception.DeletePizzaException;

public class SupprimmerUnePizzaOptionMenu extends OptionMenu {

	
	public SupprimmerUnePizzaOptionMenu (Stockage pizzaDao){
		super(pizzaDao);
	}
	
	
	public boolean execute () {
			
		Scanner question = new Scanner (System.in);
		System.out.println("4. Supprimer une pizza");
		
		Pizza[] pizzas = pizzaDao.findAllPizzas();
		
		for(int i=0; i<pizzas.length; i++) {
			// il affiche le tableau si ce n'est pas null.
			if(pizzas[i] != null)
				System.out.println(pizzas[i].getCode()+" - "+pizzas[i].getNom()+" - "+pizzas[i].getPrix());
			}
		System.out.println("Veuillez choisir la pizza à supprimer.");

		String supp = question.next();
		
		try {
			pizzaDao.deletePizza(supp);
		} catch (DeletePizzaException e) {
			System.out.println("Pizza non trouvée");
		}


		return false;
}
}

