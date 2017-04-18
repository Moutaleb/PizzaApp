package fr.pizzeria.ihm;

import java.util.List;

import fr.pizzeria.console.Pizza;
import fr.pizzeria.dao.PizzaDao;
import fr.pizzeria.dao.Stockage;

public class ListerPizzaOptionMenu extends OptionMenu { 
	
	
	public ListerPizzaOptionMenu(Stockage pizzaDao) {
		
		super(pizzaDao);
	}
	
	public boolean execute(){
		System.out.println("1. Lister les pizzas");
		
		List<Pizza> pizzas = pizzaDao.findAllPizzas();
		
		// Parcours tout le tableau.
		for(int i=0; i<pizzas.size(); i++) {
			if(pizzas.get(i)!= null)
				System.out.println(pizzas.get(i).getCode()+" - "+pizzas.get(i).getNom()+" - "+pizzas.get(i).getPrix());
		}
		return false;
	}

}
