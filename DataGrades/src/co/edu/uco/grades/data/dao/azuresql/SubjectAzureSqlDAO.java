package co.edu.uco.grades.data.dao.azuresql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import co.edu.uco.grade.dto.SubjectDTO;
import co.edu.uco.grades.crosscutting.exception.GradesException;
import co.edu.uco.grades.data.dao.SubjectDAO;
import co.edu.uco.grades.data.dao.connection.ConnectionSQL;

public class SubjectAzureSqlDAO extends ConnectionSQL implements SubjectDAO{

	private SubjectAzureSqlDAO(Connection connection) {
		super(connection);
		
	}
	
	public static SubjectDAO build(Connection connection) {
		return new SubjectAzureSqlDAO(connection);
	}

	@Override
	public void create(SubjectDTO Subject) {
		
		String sql = "INSERT INTO Subject (name) VALUES (?)";
		
		try(PreparedStatement preparedStatement = getConnection().prepareStatement(sql)){
			
			preparedStatement.setObject(1, Subject.getName() );
			
		} catch (SQLException exception) {
			throw GradesException.buildTechnicalDataException(
					"There was a problem trying to create the new subject on Azure SQL Server", exception);
			
		} catch (Exception exception) {
			throw GradesException.buildTechnicalDataException(
					"An unexpected problem has ocurred trying to create the new subject on Azure SQL Server", exception);
		}
	}

	@Override
	public void update(SubjectDTO subject) {
		String sql = "UPDATE Subject SET name = ? where id = ?";
		try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql)) {

			preparedStatement.setString(1, subject.getName());

			preparedStatement.executeUpdate();

		} catch (SQLException exception) {
			throw GradesException.buildTechnicalDataException(
					"There was a problem trying to update the new subject on Azure SQL Server", exception);
		} catch (Exception exception) {
			throw GradesException.buildTechnicalDataException(
					"An unexpected problem has ocurred trying to update the new subject on Azure SQL Server", exception);
		}
		
	}

	@Override
	public void delete(int id) {
		String sql = "Delete Subject SET where id=?";
		try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql)) {

			preparedStatement.setInt(1, id);

			preparedStatement.executeUpdate();

		} catch (SQLException exception) {
			throw GradesException.buildTechnicalDataException(
					"There was a problem trying to delete the a Subject on Azure SQL Server", exception);
		} catch (Exception exception) {
			throw GradesException.buildTechnicalDataException(
					"An unexpected problem has ocurred trying to delete a Subject on Azure SQL Server", exception);
		}
	}

	@Override
	public void find(SubjectDTO Subject) {

		
	}
	
	
	

}
