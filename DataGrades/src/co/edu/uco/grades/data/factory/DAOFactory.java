package co.edu.uco.grades.data.factory;


import co.edu.uco.grades.data.dao.StundentDAO;

public abstract class DAOFactory {
	
	public static DAOFactory getDAOFactory() {
		return null;
	}
	public abstract void commit();
	
	public abstract  void rollback();
	
	public abstract void openConnection();
	
	public abstract void closeConnection();
	
	public abstract void getConnection();
	
	public abstract StundentDAO getStundentDAO();

}
