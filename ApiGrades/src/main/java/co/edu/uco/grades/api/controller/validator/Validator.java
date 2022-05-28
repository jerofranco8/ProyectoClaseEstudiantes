package co.edu.uco.grades.api.controller.validator;

import java.util.ArrayList;
import java.util.List;

public interface Validator<D> {
	
	List<String> validate(D dto);
}
