package co.edu.uco.grades.data.dao;

import co.edu.uco.grade.dto.CourseDTO;

public interface CourseDAO {

	void create(CourseDTO course);

	void update(CourseDTO course);

	void delete(int id);

	void find(CourseDTO course);
	

}
