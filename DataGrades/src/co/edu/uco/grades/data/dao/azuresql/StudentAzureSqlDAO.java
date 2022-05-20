package co.edu.uco.grades.data.dao.azuresql;

import java.sql.Connection;

import co.edu.uco.grade.dto.StudentDTO;
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
		// TODO Auto-generated method stub

	}

	@Override
	public void update(StudentDTO student) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void find(StudentDTO student) {
		// TODO Auto-generated method stub

	}

	
}
