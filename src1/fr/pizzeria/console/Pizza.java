package fr.pizzeria.console;

public class Pizza {

	private int id;
	private static int genId;
	private String code;
	private String nom;
	private double prix;

	public Pizza(String code, String nom, double prix) {

		genId++;

		this.id = genId;
		this.code = code;
		this.nom = nom;
		this.prix = prix;
	}

	public Pizza(String code2, String string, Double double1, CategoriePizza valueOf2) {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

}
