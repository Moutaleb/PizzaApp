package fr.pizzeria.model;

/**
 * Classe pizza
 * 
 * @author Quentin DANIEL
 *
 */

public class Pizza {

	public static int nbPizza;
	
	private int id;
	private String code;
	private String nom;
	private double prix;
	private CategoriePizza categorie;
	
	
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


	/**
	 * Constructor
	 * 
	 * @param code:
	 *            ref pizza
	 * @param nom
	 * @param prix
	 */
	public Pizza(String code, String nom, double prix, CategoriePizza categorie) {
//		super();
		id = nbPizza++;
		this.code = code;
		this.nom = nom;
		this.prix = prix;
		this.categorie = categorie;
		
	}
	@Deprecated
	public Pizza(String code, String nom, double prix) {
//		super();
		id = nbPizza++;
		this.code = code;
		this.nom = nom;
		this.prix = prix;
	}
	
	@Deprecated
	public Pizza(int indice, String code, String nom, double prix) {
//		super();
		this.id = indice;
		this.code = code;
		this.nom = nom;
		this.prix = prix;
	}

	/**
	 * Afficher une pizza
	 * 
	 * @return String
	 */
	public String display() {
		return id + " " + code + "  " + nom + "   " + prix;
	}

}// END PIZZA
