package fr.pizzeria.ihm;

import fr.pizzeria.exception.DeletePizzaException;

public class SupprimerPizzaOptionMenu extends OptionMenu {

	public SupprimerPizzaOptionMenu(String libele) {
		super(libele);
	}

	@Override
	public boolean execute() {

		String codesupp;
		codesupp = PersonalScanner.chercherCode();
		
		try {
			pizzas.deletePizza(codesupp);
			System.out.println("suppression reussi");
			return true;
		} catch (DeletePizzaException e) {
			System.err.println("code pizza non trouve");
			return false;
		}
	}

}
