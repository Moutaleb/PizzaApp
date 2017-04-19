package fr.pizzeria.ihm;

import java.util.Locale;
import java.util.Scanner;

import fr.pizzeria.exception.UpdatePizzaException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class ModifierPizzaOptionMenu extends OptionMenu {

	public ModifierPizzaOptionMenu(String libele) {
		super(libele);
	}

	@Override
	public boolean execute() {

		@SuppressWarnings("resource")
		Scanner inputScanner = new Scanner(System.in);
		inputScanner.useLocale(Locale.US);

		String code, nom, codemaj;
		double prix;
		CategoriePizza categorie;

		
		codemaj = PersonalScanner.chercherCode();
		code = PersonalScanner.askCode();
		nom = PersonalScanner.askNom();
		prix = PersonalScanner.askPrix();
		categorie = PersonalScanner.askCategorie();

		try {
			pizzas.updatePizza(codemaj, new Pizza(code, nom, prix, categorie));
		} catch (UpdatePizzaException e) {
			System.err.println("ERREUR modification pizza");
			e.printStackTrace();
		}

		System.out.println("modification reussi");

		return true;
	}

}
