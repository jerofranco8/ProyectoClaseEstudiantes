package co.edu.uco.busineelogic.business;

import co.edu.uco.grade.dto.CourseDTO;

public interface CourseBusiness {
	
	void create(CourseDTO dto);

	void update(CourseDTO dto);

	void delete(int id);
	
	void find(CourseDTO dto);
	
}
