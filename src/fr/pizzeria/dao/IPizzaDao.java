package fr.pizzeria.dao;

import java.util.List;

import fr.pizzeria.exception.*;
import fr.pizzeria.model.Pizza;

public interface IPizzaDao {
	public List<Pizza> findAllPizzas();
	public Pizza findPizzaById(int id);
	public Pizza findPizzaByCode(String code);
	public boolean saveNewPizza(Pizza pizza) throws SavePizzaException;
	public boolean updatePizza(String codePizza, Pizza pizza) throws UpdatePizzaException;
	public boolean deletePizza(String codePizza) throws DeletePizzaException;
}
