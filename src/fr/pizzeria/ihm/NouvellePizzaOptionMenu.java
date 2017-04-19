package fr.pizzeria.ihm;

import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class NouvellePizzaOptionMenu extends OptionMenu {

	public NouvellePizzaOptionMenu(String libele) {
		super(libele);
	}

	@Override
	public boolean execute() {

		String code, nom;
		double prix;
		CategoriePizza cat;


		code = PersonalScanner.askCode();
		nom = PersonalScanner.askNom();
		prix = PersonalScanner.askPrix();
		cat = PersonalScanner.askCategorie();

		try {
			pizzas.saveNewPizza(new Pizza(code, nom, prix, cat));
		} catch (SavePizzaException e) {
			System.err.println("ERREUR: ajout pizza");
			e.printStackTrace();
		}

		System.out.println("Ajout reussis");

		return true;
	}

}
