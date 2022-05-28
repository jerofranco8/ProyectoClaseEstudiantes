package co.edu.uco.grades.busineelogic.business;

import co.edu.uco.grade.dto.ProfessorDTO;

public interface ProfessorBussines {
	
void create (ProfessorDTO dto);
	
	void update (ProfessorDTO dto);
	
	void delete(int id);
	
	void find (ProfessorDTO dto);

}
