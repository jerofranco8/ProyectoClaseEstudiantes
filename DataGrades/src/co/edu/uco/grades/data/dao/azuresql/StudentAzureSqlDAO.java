package co.edu.uco.grades.data.dao.azuresql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;import co.edu.uco.grade.dto.IdTypeDTO;
import co.edu.uco.grade.dto.StudentDTO;
import co.edu.uco.grades.crosscutting.exception.GradesException;
import co.edu.uco.grades.data.dao.StundentDAO;
import co.edu.uco.grades.data.dao.connection.ConnectionSQL;

public class StudentAzureSqlDAO extends ConnectionSQL implements StundentDAO{

	private StudentAzureSqlDAO(Connection connection) {
		super(connection);
	}

	public static StundentDAO build(Connection connection) {
		return new StudentAzureSqlDAO(connection);
	}

	@Override
	public void create(StudentDTO student) {
		String sql = "INSERT INTO Student(idType,idNumber,name,email) VALUES (?,?,?,?)";
		
		try(PreparedStatement preparedStatement = getConnection().prepareStatement(sql)){
			
			preparedStatement.setObject(1, student.getIdType());
			preparedStatement.setString(2, student.getIdNumber());
			preparedStatement.setString(3, student.getName());
			preparedStatement.setString(4, student.getEmail());
			
		} catch (SQLException exception) {
			throw GradesException.buildTechnicalDataException(
					"There was a problem trying to create the new Student on Azure SQL Server", exception);
			
		} catch (Exception exception) {
			throw GradesException.buildTechnicalDataException(
					"An unexpected problem has ocurred trying to create the new Studente on Azure SQL Server", exception);
		}
	}

	@Override
	public void update(StudentDTO student) {
		
		String sql = "UPDATE Student SET name = ?, email= ? where id = ?";
		try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql)) {

			preparedStatement.setString(1, student.getName());
			preparedStatement.setString(2, student.getEmail());
			preparedStatement.setInt(3, student.getId());

			preparedStatement.executeUpdate();

		} catch (SQLException exception) {
			throw GradesException.buildTechnicalDataException(
					"There was a problem trying to update the new student on Azure SQL Server", exception);
		} catch (Exception exception) {
			throw GradesException.buildTechnicalDataException(
					"An unexpected problem has ocurred trying to update the new student on Azure SQL Server", exception);
		}

	}

	@Override
	public void delete(int id) {
		String sql = "Delete student SET where id=?";
		
		try(PreparedStatement preparedStatement = getConnection().prepareStatement(sql)){
			
			preparedStatement.setInt(1, id );
		} catch (SQLException exception) {
			throw GradesException.buildTechnicalDataException(
					"There was a problem trying to delete a Student on Azure SQL Server", exception);
			
		} catch (Exception exception) {
			throw GradesException.buildTechnicalDataException(
					"An unexpected problem has ocurred trying to delete a Studente on Azure SQL Server", exception);
		}
	}

	@Override
	public void find(StudentDTO student) {


	}

	
}
