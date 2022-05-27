package co.edu.uco.grades.data.dao.azuresql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import co.edu.uco.grade.dto.ProfessorDTO;
import co.edu.uco.grades.crosscutting.exception.GradesException;
import co.edu.uco.grades.data.dao.ProfessorDAO;
import co.edu.uco.grades.data.dao.connection.ConnectionSQL;

public class ProfessorAzureSqlDAO extends ConnectionSQL implements ProfessorDAO {

	private ProfessorAzureSqlDAO(Connection connection) {
		super(connection);
	}
	
	public static ProfessorDAO build(Connection connection) {
		return new ProfessorAzureSqlDAO(connection);
	}

	@Override
	public void create(ProfessorDTO professor) {
		String sql = "INSERT INTO professor(idType,idNumber,name,email) VALUES (?,?,?,?)";
		
		try(PreparedStatement preparedStatement = getConnection().prepareStatement(sql)){
			
			preparedStatement.setObject(1, professor.getIdType());
			preparedStatement.setString(2, professor.getIdNumber());
			preparedStatement.setString(3, professor.getName());
			preparedStatement.setString(4, professor.getEmail());
			
		} catch (SQLException exception) {
			throw GradesException.buildTechnicalDataException(
					"There was a problem trying to create the new professor on Azure SQL Server", exception);
			
		} catch (Exception exception) {
			throw GradesException.buildTechnicalDataException(
					"An unexpected problem has ocurred trying to create the new professor on Azure SQL Server", exception);
		}
		
	}

	@Override
	public void update(ProfessorDTO professor) {
		String sql = "UPDATE professor SET name = ?, email= ? where id = ?";
		try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql)) {

			preparedStatement.setString(1, professor.getName());
			preparedStatement.setString(2, professor.getEmail());
			preparedStatement.setInt(3, professor.getId());

			preparedStatement.executeUpdate();

		} catch (SQLException exception) {
			throw GradesException.buildTechnicalDataException(
					"There was a problem trying to update the new professor on Azure SQL Server", exception);
		} catch (Exception exception) {
			throw GradesException.buildTechnicalDataException(
					"An unexpected problem has ocurred trying to update the new professor on Azure SQL Server", exception);
		}
		
	}

	@Override
	public void delete(int id) {
		String sql = "Delete professor SET where id=?";
		
		try(PreparedStatement preparedStatement = getConnection().prepareStatement(sql)){
			
			preparedStatement.setInt(1, id );
		} catch (SQLException exception) {
			throw GradesException.buildTechnicalDataException(
					"There was a problem trying to delete a professor on Azure SQL Server", exception);
			
		} catch (Exception exception) {
			throw GradesException.buildTechnicalDataException(
					"An unexpected problem has ocurred trying to delete a professor on Azure SQL Server", exception);
		}
		
	}

	@Override
	public void find(ProfessorDTO professor) {

		
	}
	
}
