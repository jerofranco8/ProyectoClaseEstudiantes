package co.edu.uco.grades.busineelogic.business;

import co.edu.uco.grade.dto.StudentDTO;

public interface StudentBusiness {
	
	void create(StudentDTO dto);

	void update(StudentDTO dto);

	void delete(int id);

	void find(StudentDTO dto);
}
