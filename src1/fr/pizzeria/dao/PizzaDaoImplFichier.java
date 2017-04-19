package fr.pizzeria.dao;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import fr.pizzeria.console.CategoriePizza;
import fr.pizzeria.console.Pizza;
import fr.pizzeria.exception.DeletePizzaException;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.exception.StockageException;
import fr.pizzeria.exception.UpdatePizzaException;

public class PizzaDaoImplFichier implements Stockage {	

	private String dataDir;

	public PizzaDaoImplFichier(String dataDir) {
		super();
		this.dataDir = dataDir;
	}

	@Override
	public List<Pizza> findAllPizzas() {

		try {
			return Files.list(Paths.get(dataDir)).map(path -> {
				
				String code = path.toFile().getName().replaceAll(".txt","");
				
				try {
					String[] valueTab = Files.lines(path)
												.findFirst()
												.orElseThrow(() -> new StockageException())
												.split(";");
					
					return new Pizza(code, valueTab[0], Double.valueOf(valueTab[1]),  CategoriePizza.valueOf(valueTab[2]));
					
				} catch (IOException e) {
					throw new StockageException(e);
				}
			}).collect(Collectors.toList());
		} catch (IOException e) {
			throw new StockageException(e);
		}
	}

	@Override
	public Pizza findPizzaById(int id) {
		return null;
	}

	@Override
	public Pizza findPizzaByCode(String code) {
		return null;
	}

	@Override
	public boolean saveNewPizza(Pizza pizza) throws SavePizzaException {
		return false;
	}

	@Override
	public boolean updatePizza(String codePizza, Pizza pizza) throws UpdatePizzaException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deletePizza(String codePizza) throws DeletePizzaException {
		// TODO Auto-generated method stub
		return false;
	}

}
