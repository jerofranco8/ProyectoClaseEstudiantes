package co.edu.uco.grades.data.dao.azuresql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import co.edu.uco.grade.dto.CourseDTO;
import co.edu.uco.grades.crosscutting.exception.GradesException;
import co.edu.uco.grades.data.dao.CourseDAO;
import co.edu.uco.grades.data.dao.connection.ConnectionSQL;

public class CourseAzureSqlDAO extends ConnectionSQL implements CourseDAO {

	private CourseAzureSqlDAO(Connection connection) {
		super(connection);
	}
	
	public static CourseDAO build(Connection connection) {
		return new CourseAzureSqlDAO(connection);
	}

	@Override
	public void create(CourseDTO course) {
		String sql = "INSERT INTO Course (subject,professor,initialDate,finalDate) VALUES (?,?,?,?)";

		try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql)) {

			preparedStatement.setObject(1, course.getSubject());
			preparedStatement.setObject(2, course.getProfessor());
			preparedStatement.setDate(3, course.getInitialDate());
			preparedStatement.setDate(4, course.getFinalDate());

			preparedStatement.executeUpdate();

		} catch (SQLException exception) {
			throw GradesException.buildTechnicalDataException(
					"There was a problem trying to create the new IdType on Azure SQL Server", exception);
		} catch (Exception exception) {
			throw GradesException.buildTechnicalDataException(
					"An unexpected problem has ocurred trying to create the new IdType on Azure SQL Server", exception);
		}
		
	}

	@Override
	public void update(CourseDTO course) {
		
		
	}

	@Override
	public void delete(int id) {
		String sql = "Delete Course SET where id=?";
		
		try(PreparedStatement preparedStatement = getConnection().prepareStatement(sql)){
			
			preparedStatement.setInt(1, id );
		} catch (SQLException exception) {
			throw GradesException.buildTechnicalDataException(
					"There was a problem trying to delete a Course on Azure SQL Server", exception);
			
		} catch (Exception exception) {
			throw GradesException.buildTechnicalDataException("An unexpected problem has ocurred trying to delete a Course on Azure SQL Server", exception);
		}
				
		
	}

	@Override
	public void find(CourseDTO course) {
		
		
	}
	

}
