package co.edu.uco.busineelogic.business.impl;

import co.edu.uco.busineelogic.business.StudentBusiness;
import co.edu.uco.crosscuting.util.object.UtilObject;
import co.edu.uco.grade.dto.StudentDTO;
import co.edu.uco.grades.crosscutting.exception.GradesException;
import co.edu.uco.grades.data.factory.DAOFactory;

public class StudentBusinessImpl implements StudentBusiness {

	private DAOFactory daoFactory;

	public StudentBusinessImpl(DAOFactory daoFactory) {
		if (UtilObject.getUtilObject().isNull(daoFactory)) {
			throw GradesException.buildTechnicalBusinessLogicException(
					"It's no possible create a StudentBusinessImpl whem the DAOfactory is null");
		}

	}

	@Override
	public void create(StudentDTO dto) {
		daoFactory.getStudentDAO().create(dto);

	}

	@Override
	public void update(StudentDTO dto) {
		daoFactory.getStudentDAO().update(dto);

	}

	@Override
	public void delete(int id) {
		daoFactory.getStudentDAO().delete(id);
	}

	@Override
	public void find(StudentDTO dto) {
		daoFactory.getStudentDAO().find(dto);
	}

}
