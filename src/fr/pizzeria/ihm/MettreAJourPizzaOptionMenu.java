package fr.pizzeria.ihm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import fr.pizzeria.console.Pizza;
import fr.pizzeria.dao.Stockage;
import fr.pizzeria.exception.UpdatePizzaException;


public class MettreAJourPizzaOptionMenu extends OptionMenu {
	

	public MettreAJourPizzaOptionMenu (Stockage pizzaDao){
		super(pizzaDao);
	}

	
	public boolean execute() {
		Scanner question = new Scanner (System.in);
		
		System.out.println("3. Mettre à jour une pizza");
		
		List<Pizza> pizzas = pizzaDao.findAllPizzas();
		
		for(int i=0; i<pizzas.size(); i++) {
			if(pizzas.get(i) != null)
				System.out.println(pizzas.get(i).getCode()+" - "+pizzas.get(i).getNom()+" - "+pizzas.get(i).getPrix());
			}
		System.out.println("Veuillez choisir le code de la pizza a modifier.");
		String codepizzaAmodifier = question.next();
		
		
		System.out.println("Veuillez saisir le code:");
		String code = question.next();
		System.out.println("Veuillez saisir le nom (sans espace):");
		String libelle = question.next();
		System.out.println("Veuillez saisir le prix");
		double prix = question.nextDouble();
		
		
		//List<Pizza> pizza = new ArrayList<>();
    	Pizza pizza = new Pizza (code,libelle,prix);
		
		try {
			pizzaDao.updatePizza(codepizzaAmodifier, pizza);
		} catch (UpdatePizzaException e) {
			// TODO Auto-generated catch block
			System.out.println("Le code pizza est introuvable :3");
		}
		
		return false;
	}
	
}
