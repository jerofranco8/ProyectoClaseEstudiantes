package co.edu.uco.grades.busineelogic.business.impl;

import co.edu.uco.crosscuting.util.object.UtilObject;
import co.edu.uco.grade.dto.SubjectDTO;
import co.edu.uco.grades.busineelogic.business.SubjectBusiness;
import co.edu.uco.grades.crosscutting.exception.GradesException;
import co.edu.uco.grades.data.factory.DAOFactory;

public class SubjectBusinessImpl implements SubjectBusiness {

	private DAOFactory daoFactory;

	public SubjectBusinessImpl(DAOFactory daoFactory) {
		if (UtilObject.getUtilObject().isNull(daoFactory)) {
			throw (GradesException.buildTechnicalBusinessLogicException(
					"It's no possible create a SubjectBusinessImpl whem the DAOfactory is null"));
		}
		this.daoFactory = daoFactory;
	}

	@Override
	public void create(SubjectDTO dto) {

		daoFactory.getSubjectDAO().create(dto);

	}

	@Override
	public void update(SubjectDTO dto) {

		daoFactory.getSubjectDAO().update(dto);

	}

	@Override
	public void delete(int id) {

		daoFactory.getSubjectDAO().delete(id);

	}

	@Override
	public void find(SubjectDTO dto) {

		daoFactory.getSubjectDAO().find(dto);
	}

}
