package co.edu.uco.grades.data.factory;


import java.sql.Connection;

import javax.swing.AbstractAction;

import co.edu.uco.grades.data.dao.IdTypeDAO;
import co.edu.uco.grades.data.dao.StundentDAO;

public abstract class DAOFactory {
	
	public static DAOFactory getDaoFactory() {
		return null;
	}

	protected abstract void openConnection();

	protected abstract Connection getConnection();

	public abstract void initTransaction();

	public abstract void closeConnection();

	public abstract void commitTransaction();

	public abstract void rollbackTransaction();

	public abstract StundentDAO getStudentDAO();

	public abstract IdTypeDAO getIdTypeDAO();
}
