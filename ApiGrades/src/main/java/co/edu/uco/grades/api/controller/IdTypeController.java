package co.edu.uco.grades.api.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpStatusCodeException;

import co.edu.uco.crosscuting.util.object.UtilObject;
import co.edu.uco.grade.dto.IdTypeDTO;
import co.edu.uco.grades.api.controller.response.Response;
import co.edu.uco.grades.api.controller.validator.Validator;
import co.edu.uco.grades.api.controller.validator.idType.CreateIdTypeValidator;
import co.edu.uco.grades.busineelogic.facade.IdTypeFacade;
import co.edu.uco.grades.busineelogic.facade.Impl.IdTypeFacadeImpl;
import co.edu.uco.grades.crosscutting.exception.GradesException;
import co.edu.uco.grades.crosscutting.exception.enumeracion.ExceptionType;

@RestController
@RequestMapping("/api/v1/idType")
public class IdTypeController {
	
	
	@GetMapping("/dummy")
	public IdTypeDTO getDummy() {
		return new IdTypeDTO();
	}
	
	@PostMapping
	public ResponseEntity<Response<IdTypeDTO>> create(@RequestBody IdTypeDTO dto) {
		Validator<IdTypeDTO> validator = new CreateIdTypeValidator();
		
		List<String> messages = UtilObject.getUtilObject().getDefault(validator.validate(dto), new ArrayList<>());
		
		Response<IdTypeDTO> response = new Response<>();
		ResponseEntity<Response<IdTypeDTO>> responseEntity;
		HttpStatus statusCode = HttpStatus.BAD_REQUEST;
		if(messages.isEmpty()) {
			try {
				IdTypeFacade facade= new IdTypeFacadeImpl();
				facade.create(dto);
				statusCode = HttpStatus.OK;
				messages.add("Id type was created succesfully");
			} catch(GradesException exception){
				if(ExceptionType.TECHNICAL.equals(exception.getType())) {
					messages.add("There was a problem trying to register the new id Type. ");
					System.err.println(exception.getLocation());
					System.err.println(exception.getType());
					System.err.println(exception.getMessage());
					exception.getRootException().printStackTrace();
					
				}else {
					messages.add(exception.getUserMessage());
					System.err.println(exception.getLocation());
					System.err.println(exception.getType());
					System.err.println(exception.getMessage());
					exception.getRootException().printStackTrace();
				}
				}catch(Exception exception) {
					messages.add("There was a problem trying to register the new id Type, please try aganin");
					exception.printStackTrace();
				}
			}
		response.setMessages(messages);
		responseEntity = new ResponseEntity<>(response,statusCode);
		
		return responseEntity;
			
	}
	
	@PutMapping("/{id}")
	public void update(@PathVariable("id") int id, @RequestBody IdTypeDTO dto) {
		System.out.println("Estoy en actualizar!!");
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") int id) {
		System.out.println("Estoy en eliminar!!");
	}
	
	@GetMapping("/{id}")
	public void findById(@PathVariable("id") int id) {
		System.out.println("Estoy en consultar por id!!");
	}
	@GetMapping
	public ResponseEntity<Response<IdTypeDTO>> find() {

		
		List<String> messages = new ArrayList<>();
		
		Response<IdTypeDTO> response = new Response<>();
		ResponseEntity<Response<IdTypeDTO>> responseEntity;
		HttpStatus statusCode = HttpStatus.BAD_REQUEST;
		
		
			try {
				IdTypeFacade facade= new IdTypeFacadeImpl();
				response.setData(facade.find(new IdTypeDTO()));
				statusCode = HttpStatus.OK;
				messages.add("Id type were found succesfully");
			} catch(GradesException exception){
				if(ExceptionType.TECHNICAL.equals(exception.getType())) {
					messages.add("There was a problem trying to find id Type. ");
					System.err.println(exception.getLocation());
					System.err.println(exception.getType());
					System.err.println(exception.getMessage());
					exception.getRootException().printStackTrace();
					
				}else {
					messages.add(exception.getUserMessage());
					System.err.println(exception.getLocation());
					System.err.println(exception.getType());
					System.err.println(exception.getMessage());
					exception.getRootException().printStackTrace();
				}
				}catch(Exception exception) {
					messages.add("There was a problem trying to find id Type, please try aganin");
					exception.printStackTrace();
				}
			
		response.setMessages(messages);
		responseEntity = new ResponseEntity<>(response,statusCode);
		
		return responseEntity;
	}
}
