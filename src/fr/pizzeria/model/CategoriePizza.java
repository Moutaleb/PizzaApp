package fr.pizzeria.model;

public enum CategoriePizza {
	

	VIANDE ("Viande"),
	POISSON("Poisson"),
	SANS_VIANDE("Sans Viande");
	
	private String libele;
	
	public String getLibele() {
		return libele;
	}
	
	private CategoriePizza(String libele) {
		this.libele = libele;
	}
	

}
