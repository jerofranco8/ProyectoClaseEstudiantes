package co.edu.uco.grades.api.controller.validator.idType;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.crosscuting.util.object.UtilObject;
import co.edu.uco.grade.dto.IdTypeDTO;
import co.edu.uco.grades.api.controller.validator.Validator;

public class CreateIdTypeValidator implements Validator<IdTypeDTO> {

	
	private List<String> validationMessages = new ArrayList<>();
	@Override
	public List<String> validate(IdTypeDTO dto) {
		if (UtilObject.getUtilObject().isNull(dto)) {
			validationMessages.add("Is not possible  valdiate idType Data");
		
		}
		dto.validateName(validationMessages);
		return validationMessages;
	}
	
	
}
