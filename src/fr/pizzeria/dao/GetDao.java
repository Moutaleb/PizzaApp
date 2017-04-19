package fr.pizzeria.dao;

public class GetDao {

	private GetDao() {

	}
//	private static GetDao INSTANCE  = new GetDao();
	private static IPizzaDao dao;
	
//	public static GetDao getIstance() {		
//		return INSTANCE;
//	}
	
	public static void set(IPizzaDao dao){
		GetDao.dao = dao;
	}
	
	public static IPizzaDao get(){
		if(dao == null)
			dao = new PizzaDaoImplTableau();
		
		return dao;
	}
	
	

}
