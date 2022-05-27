package co.edu.uco.grade.dto;

import co.edu.uco.crosscuting.util.text.UtilText;

public class SubjectDTO {
	
	private int id;
	private String name;
	
	
	public SubjectDTO() {
		super();
		setName(UtilText.EMPTY);
	}
	
	public SubjectDTO(int id, String name) {
		super();
		setId(id);
		setName(name);
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = UtilText.getDefault(name);
	}
	
	
}
