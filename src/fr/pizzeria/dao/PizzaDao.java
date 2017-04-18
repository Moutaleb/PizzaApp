package fr.pizzeria.dao;

import fr.pizzeria.console.Pizza;
import fr.pizzeria.exception.DeletePizzaException;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.exception.UpdatePizzaException;

public class PizzaDao implements Stockage {

	private Pizza[] pizzas;
	
	public PizzaDao (Pizza [] pizzas){
		this.pizzas=pizzas;
	}

	@Override
	public Pizza[] findAllPizzas() {	

		return pizzas;
	}


	@Override
	public void saveNewPizza(Pizza pizza) throws SavePizzaException {
		
		
		// verif pizza deja existante
		for (int i=0; i<pizzas.length; i++)
		{		
			
			if (pizzas[i]!=null && pizzas[i].getCode().equals(pizza.getCode()))
			{
				throw new SavePizzaException ();
			}	
		}
		
		// ajout de pizza
		for (int i=0; i<pizzas.length; i++)
		{
			
			
			if (pizzas[i]==null)
			{
				pizzas [i] = pizza;
				break;
			
			} 
			
		}
        
		
	}



	@Override
	public void updatePizza(String codePizza, Pizza pizza) throws UpdatePizzaException {

        boolean trouver = false;
		for(int i=0;i<pizzas.length; i++){
			if(pizzas[i]!=null && pizzas[i].getCode().equals(codePizza) )
			{
				pizzas[i]=pizza;
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
		
		for (int i=0; i<pizzas.length; i++)
		{
			// vérifie la pizza qui veut être supprimer.
			if (pizzas[i]!=null && codePizza.equals(pizzas[i].getCode()))
			{	
				// suppression de la pizza qui a etait saisie.
				pizzas[i]= null;
				aucunePizzaTrouve = false;
			}
		}
		if(aucunePizzaTrouve){
			throw new DeletePizzaException();
		}

	}
}
