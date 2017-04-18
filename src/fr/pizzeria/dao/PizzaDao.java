package fr.pizzeria.dao;

import java.util.List;

import fr.pizzeria.console.Pizza;
import fr.pizzeria.exception.DeletePizzaException;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.exception.UpdatePizzaException;

public class PizzaDao implements Stockage {

	private List<Pizza> pizzas;
	
	public PizzaDao (List<Pizza> pizzas){
		this.pizzas=pizzas;
	}

	@Override
	public List<Pizza> findAllPizzas() {	

		return pizzas;
	}


	@Override
	public void saveNewPizza(Pizza pizza) throws SavePizzaException {
		
		
		// verif pizza deja existante
		for (int i=0; i<pizzas.size(); i++)
		{		
			
			if (pizzas.get(i)!=null && pizzas.get(i).getCode().equals(pizza.getCode()))
			{
				throw new SavePizzaException ();
			}	
		}
		
		pizzas.add(pizza);
		
		/*
		// ajout de pizza
		for (int i=0; i<pizzas.size(); i++)
		{
			
			
			if (pizzas.get(i)==null)
			{
				pizzas [i] = pizza;
				break;
			
			} 
			
		}
        */
		
	}



	@Override
	public void updatePizza(String codePizza, Pizza pizza) throws UpdatePizzaException {

        boolean trouver = false;
		for(int i=0;i<pizzas.size(); i++){
			Pizza pizzaCourante = pizzas.get(i);
			if(pizzaCourante!=null && pizzaCourante.getCode().equals(codePizza) )
			{
				pizzaCourante.setNom(pizza.getNom());
				pizzaCourante.setPrix(pizza.getPrix());
				
				trouver = true;
			
			}
			
			
		}
		
	    	if(trouver == false)
		   {
			throw new UpdatePizzaException ();
			
		   }


	}



	@Override
	public void deletePizza(String codePizza) throws DeletePizzaException {
		boolean aucunePizzaTrouve = true;
		
		for (int i=0; i<pizzas.size(); i++)
		{
			// vérifie la pizza qui veut être supprimer.
			if (pizzas.get(i)!=null && codePizza.equals(pizzas.get(i).getCode()))
			{	
				// suppression de la pizza qui a etait saisie.
				pizzas.remove(i);
				aucunePizzaTrouve = false;
			}
		}
		if(aucunePizzaTrouve){
			throw new DeletePizzaException();
		}

	}
}
