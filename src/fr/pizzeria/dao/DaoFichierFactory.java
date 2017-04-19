package fr.pizzeria.dao;

public class DaoFichierFactory implements DaoFactory {

	
	IPizzaDao pizzaDao = new PizzaDaoImplFichier("data");
	
	@Override
	public IPizzaDao getPizzaDao() {
		
		return pizzaDao;
	}

	
}
