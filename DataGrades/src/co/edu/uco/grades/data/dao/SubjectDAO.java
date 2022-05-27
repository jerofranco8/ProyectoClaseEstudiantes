package co.edu.uco.grades.data.dao;

import co.edu.uco.grade.dto.SubjectDTO;

public interface SubjectDAO {
	
	void create(SubjectDTO Subject);

	void update(SubjectDTO Subject);

	void delete(int id);

	void find(SubjectDTO Subject);
	

}
