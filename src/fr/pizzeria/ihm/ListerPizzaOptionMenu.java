package fr.pizzeria.ihm;

import fr.pizzeria.console.Pizza;
import fr.pizzeria.dao.PizzaDao;
import fr.pizzeria.dao.Stockage;

public class ListerPizzaOptionMenu extends OptionMenu { 
	
	
	public ListerPizzaOptionMenu(Stockage pizzaDao) {
		
		super(pizzaDao);
	}
	
	public boolean execute(){
		System.out.println("1. Lister les pizzas");
		
		Pizza[] pizzas = pizzaDao.findAllPizzas();
		
		// Parcours tout le tableau.
		for(int i=0; i<pizzas.length; i++) {
			if(pizzas[i] != null)
				System.out.println(pizzas[i].getCode()+" - "+pizzas[i].getNom()+" - "+pizzas[i].getPrix());
		}
		return false;
	}

}
