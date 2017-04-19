package fr.pizzeria.dao;

public class DaoMemoireFactory implements DaoFactory {
	
	
	IPizzaDao pizzaDao = new PizzaDaoImplTableau();

	@Override
	public IPizzaDao getPizzaDao() {
		
		return pizzaDao;
	}
	
	
	

}
