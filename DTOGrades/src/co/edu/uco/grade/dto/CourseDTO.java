package co.edu.uco.grade.dto;

import java.sql.Date;
import co.edu.uco.crosscuting.util.object.UtilObject;

public class CourseDTO {
	
	private int id;
	private SubjectDTO subject;
	private ProfessorDTO professor;
	private Date initialDate;
	private Date finalDate;

	
	public CourseDTO() {
		super();
		setSubject(new SubjectDTO());
		setProfessor(new ProfessorDTO());
		setInitialDate(new Date(0));
		setFinalDate(new Date(0));
	}
	public CourseDTO(int id, SubjectDTO subject, ProfessorDTO professor, Date initialDate, Date finalDate) {
		super();
		setId(id);
		setSubject(subject);
		setProfessor(professor);
		setInitialDate(initialDate);
		setFinalDate(finalDate);
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public SubjectDTO getSubject() {
		return subject;
	}
	public void setSubject(SubjectDTO subject) {
		this.subject = UtilObject.getUtilObject().getDefault(subject, new SubjectDTO());
	}
	public ProfessorDTO getProfessor() {
		return professor;
	}
	public void setProfessor(ProfessorDTO professor) {
		this.professor = UtilObject.getUtilObject().getDefault(professor, new ProfessorDTO());
	}
	public Date getInitialDate() {
		return initialDate;
	}
	public void setInitialDate(Date initialDate) {
		this.initialDate =UtilObject.getUtilObject().getDefault(initialDate, new Date(0));
	}
	public Date getFinalDate() {
		return finalDate;
	}
	public void setFinalDate(Date finalDate) {
		this.finalDate =UtilObject.getUtilObject().getDefault(initialDate, new Date(0));
	}
	
	
	
	

}
