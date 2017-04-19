package fr.pizzeria.dao;

import fr.pizzeria.exception.DeletePizzaException;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.exception.UpdatePizzaException;
import fr.pizzeria.model.Pizza;

import java.util.*;

public class PizzaDaoImplTableau implements IPizzaDao {

	List<Pizza> pizzas = new ArrayList<>();

	@Override
	public List<Pizza> findAllPizzas() {
		return pizzas;
	}

	@Override
	public boolean saveNewPizza(Pizza pizza) throws SavePizzaException {

		if (!pizzas.add(pizza))
			throw new SavePizzaException();

		return true;
	}

	@Override
	public boolean updatePizza(String codePizza, Pizza pizza) throws UpdatePizzaException {

		int indice = trouverPizzaByCode(codePizza);

		if (indice != -1) {
			pizzas.set(indice, pizza);
			return true;
		}

		throw new UpdatePizzaException();
	}

	@Override
	public boolean deletePizza(String codePizza) throws DeletePizzaException {

		int indice = trouverPizzaByCode(codePizza);

		if (indice != -1) {
			pizzas.remove(indice);
			return true;
		}

		throw new DeletePizzaException();
	}

	@Override
	public Pizza findPizzaById(int id) {
		int indice = trouverPizzaById(id);
		if(indice !=-1)
			return pizzas.get(indice);
		
		return null;
	}

	@Override
	public Pizza findPizzaByCode(String code) {
		int indice = trouverPizzaByCode(code);
		if(indice !=-1)
			return pizzas.get(indice);
		
		
		return null;
	}

	private int trouverPizzaById(int id) {
		for (int i = 0; i < pizzas.size(); i++)
			if (pizzas.get(i).getId() == id)
				return i;

		return -1;
	}

	private int trouverPizzaByCode(String code) {
		for (int i = 0; i < pizzas.size(); i++)
			if (pizzas.get(i).getCode().equals(code))
				return i;

		return -1;

	}

}
