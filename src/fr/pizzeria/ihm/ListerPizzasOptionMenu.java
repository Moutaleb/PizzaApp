package fr.pizzeria.ihm;

import java.util.List;

import fr.pizzeria.model.Pizza;

/**
 * Affiche la liste des pizzas
 */
public class ListerPizzasOptionMenu extends OptionMenu {

	public ListerPizzasOptionMenu(String libele){
		super(libele);
	}

	@Override
	public boolean execute() {
		System.out.println("\n  Liste des pizzas");
		List<Pizza> pizzaTmp = pizzas.findAllPizzas();
		for (int i = 0; i < pizzaTmp.size(); i++) {
				System.out.println(i + ". " + pizzaTmp.get(i).display());
		}
		return true;
	}
}
