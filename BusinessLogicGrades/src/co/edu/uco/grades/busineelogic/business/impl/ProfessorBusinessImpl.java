package co.edu.uco.grades.busineelogic.business.impl;

import co.edu.uco.crosscuting.util.object.UtilObject;
import co.edu.uco.grade.dto.ProfessorDTO;
import co.edu.uco.grades.busineelogic.business.ProfessorBussines;
import co.edu.uco.grades.crosscutting.exception.GradesException;
import co.edu.uco.grades.data.factory.DAOFactory;

public class ProfessorBusinessImpl implements ProfessorBussines{

	private DAOFactory daoFactory;

	public ProfessorBusinessImpl(DAOFactory daoFactory) {
		if (UtilObject.getUtilObject().isNull(daoFactory)) {
			throw GradesException.buildTechnicalBusinessLogicException(
					"It's no possible create a ProfessorBusinessImpl whem the DAOfactory is null");
		}

	}
	
	@Override
	public void create(ProfessorDTO dto) {
		
		daoFactory.getProfessorDAO().create(dto);
		
	}

	@Override
	public void update(ProfessorDTO dto) {
		daoFactory.getProfessorDAO().update(dto);
		
	}

	@Override
	public void delete(int id) {
		daoFactory.getProfessorDAO().delete(id);
		
	}

	@Override
	public void find(ProfessorDTO dto) {
		daoFactory.getProfessorDAO().find(dto);
		
	}

	

}
