package fr.pizzeria.ihm;

import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Pattern;

import fr.pizzeria.dao.GetDao;
import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class PersonalScanner {

	static IPizzaDao dao = GetDao.get();
	static Scanner mainScaner = new Scanner(System.in);//.useDelimiter("\\n");

	private PersonalScanner() {

		// mainScaner = new Scanner(System.in);
		mainScaner.useLocale(Locale.US);
	}

	private static boolean pizzaCodeExist(String code) {
		Pizza p = dao.findPizzaByCode(code);
		if (p != null)
			return true;

		return false;
	}

	public static String askCode() {
		while (true) {
			System.out.print("Entre CODE pizza: ");
			String str = mainScaner.next();
			if (str.length() == 3)
				return str.toUpperCase();

			System.out.println("Code non valide...");
		}
	}

	public static String chercherCode() {
		while (true) {
			System.out.print("Selectionner code pizza rechercher: ");
			String str = mainScaner.next();
			str = str.toUpperCase();
			if (pizzaCodeExist(str))
				return str;

			System.out.println("Code non trouver...");
		}
	}

	public static String askNom() {
		while (true) {
			System.out.print("Entre NOM pizza: ");
			
			// PUTIN DE LIGNE VIDE DE MERDE !!!
			mainScaner.nextLine();
			String str = mainScaner.nextLine();

			str = str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();

			String decimalPattern = "[a-zA-Z\\s]+";
			boolean match = Pattern.matches(decimalPattern, str);
			if (match)
				return str;

			System.out.println("Nom non valide...");
		}
	}

	public static CategoriePizza askCategorie() {
				
		for (int i = 0; i < CategoriePizza.values().length; i++) {
			System.out.println(i + ". " + CategoriePizza.values()[i].getLibele());
		}
		
		
		while (true) {
			System.out.print("Entre code categorie: ");
			String str = mainScaner.next();

			String decimalPattern = "[0-9]*";
			boolean match = Pattern.matches(decimalPattern, str);
			if (match) {
				int value = Integer.parseInt(str);
				if (value < CategoriePizza.values().length)
					return CategoriePizza.values()[value];
			}
			System.out.println("Categorie non valide...");
		}
	}

	public static double askPrix() {
		while (true) {
			System.out.print("Entre PRIX pizza: ");
			String str = mainScaner.next();

			String decimalPattern = "([0-9]*)(\\.([0-9]+))?";
			boolean match = Pattern.matches(decimalPattern, str);
			if (match)
				return Double.parseDouble(str);

			System.out.println("Prix non valide...");
		}
	}

	public static int askComande() {
		while (true) {
			System.out.print("Entre comande: ");
			String str = mainScaner.next();

			String decimalPattern = "[0-9]*";
			boolean match = Pattern.matches(decimalPattern, str);
			if (match)
				return Integer.parseInt(str);

			System.out.println("Commande non valide...");
		}
	}
}
