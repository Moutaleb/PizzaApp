package fr.pizzeria.ihm;

import java.util.*;
import java.util.Map.Entry;

public class Menu {
	private Map<Integer, OptionMenu> actions = new TreeMap<>();
	private String titre;
	private String fin;
	private int nbAction = 1;

	public Menu() {
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public void setFin(String fin) {
		this.fin = fin;
	}

	/**
	 * Afficher le menu
	 */
	public void afficher() {
		if (titre != null)
			System.out.println(titre);

		Set<Entry<Integer, OptionMenu>> setHm = actions.entrySet();
		Iterator<Entry<Integer, OptionMenu>> it = setHm.iterator();
		while (it.hasNext()) {
			Entry<Integer, OptionMenu> e = it.next();
			System.out.println(e.getKey() + ". " + e.getValue().getLibele());
		}

		if (titre != null)
			System.out.println(fin);
	}

	public boolean ajouterAction(int indice, OptionMenu option){
		if (!actions.containsValue(indice)) {
			actions.put(indice, option);
			return true;
		} else
			return false;
	}

	public boolean ajouterAction(OptionMenu option) {
		boolean out;
		out = ajouterAction(nbAction, option);
		if( out )
			nbAction++;
		return out;
	}

	public boolean execute(int indiceOption) {
		boolean out = true;
		if (actions.containsKey(indiceOption))
			out = actions.get(indiceOption).execute();

		else
			System.out.println("Cette commande n'existe pas...");

		return out;
	}

} // END MENU
