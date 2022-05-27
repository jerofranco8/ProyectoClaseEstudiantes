package co.edu.uco.grades.data.factory;

import java.sql.Connection;

import javax.swing.AbstractAction;

import com.microsoft.sqlserver.jdbc.SQLServerColumnEncryptionAzureKeyVaultProvider;

import co.edu.uco.grades.data.dao.CourseDAO;
import co.edu.uco.grades.data.dao.IdTypeDAO;
import co.edu.uco.grades.data.dao.ProfessorDAO;
import co.edu.uco.grades.data.dao.StundentDAO;
import co.edu.uco.grades.data.dao.SubjectDAO;
import co.edu.uco.grades.data.factory.azuresql.AzureSqlDAOFactory;

public abstract class DAOFactory {

	public static DAOFactory getDaoFactory() {
		return AzureSqlDAOFactory.create();
	}

	protected abstract void openConnection();

	protected abstract Connection getConnection();

	public abstract void initTransaction();

	public abstract void closeConnection();

	public abstract void commitTransaction();

	public abstract void rollbackTransaction();

	public abstract StundentDAO getStudentDAO();

	public abstract IdTypeDAO getIdTypeDAO();

	public abstract CourseDAO getCourseDAO();

	public abstract ProfessorDAO getProfessorDAO();

	public abstract SubjectDAO getSubjectDAO();

}
