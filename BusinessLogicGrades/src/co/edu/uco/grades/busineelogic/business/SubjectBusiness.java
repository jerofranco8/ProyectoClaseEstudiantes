package co.edu.uco.grades.busineelogic.business;

import co.edu.uco.grade.dto.SubjectDTO;

public interface SubjectBusiness {
	
	void create(SubjectDTO dto);

	void update(SubjectDTO dto);

	void delete(int id);

	void find(SubjectDTO dto);
	
}
