package fr.pizzeria.ihm;

import fr.pizzeria.dao.GetDao;
import fr.pizzeria.dao.IPizzaDao;

abstract class OptionMenu {
	private String libele;
	IPizzaDao pizzas;

	public OptionMenu(String libele) {
		this.pizzas = GetDao.get();
		this.libele = libele;
	}

	public String getLibele() {
		return libele;
	}

	public void setLibele(String libele) {
		this.libele = libele;
	}

	public abstract boolean execute();

}
