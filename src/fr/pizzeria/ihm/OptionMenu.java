package fr.pizzeria.ihm;

import fr.pizzeria.dao.Stockage;

public abstract class OptionMenu {
	
	protected Stockage pizzaDao;
	
	public OptionMenu (Stockage pizzaDao){
		this.pizzaDao = pizzaDao;
		
	}
	

}
