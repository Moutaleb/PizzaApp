package fr.pizzeria.ihm;

import java.util.List;
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
		
		List<Pizza> pizzas = pizzaDao.findAllPizzas();
		
		for(int i=0; i<pizzas.size(); i++) {
			// il affiche le tableau si ce n'est pas null.
			if(pizzas.get(i) != null)
				System.out.println(pizzas.get(i).getCode()+" - "+pizzas.get(i).getNom()+" - "+pizzas.get(i).getPrix());
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

