package net.codejava.api;

import java.util.List;
import java.util.NoSuchElementException;

import net.codejava.model.Teacher;
import net.codejava.model.dto.TeacherConventer;
import net.codejava.model.dto.TeacherDTO;
import net.codejava.service.TeacherService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TeacherController {

	@Autowired
	private TeacherService service;
	@Autowired
	TeacherConventer conventer;

	@GetMapping("/teachers")
	public List<TeacherDTO> list() {
		List<Teacher>listAll =  service.listAll();
		return conventer.entityToDto(listAll);
	}

	@GetMapping("/teachers/{id}")
	public ResponseEntity<TeacherDTO> get(@PathVariable Integer id) {
		try {
		Teacher teacher = service.get(id);
		
		return new ResponseEntity<TeacherDTO>(conventer.entityToDto(teacher), HttpStatus.OK);
		}catch(NoSuchElementException e) {
			return new ResponseEntity<TeacherDTO>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/teachers")
	public void add(@RequestBody Teacher teacher) {
		service.save(teacher);
	}
	
	@PutMapping("/teachers/{id}")
	public ResponseEntity<Teacher>update(@RequestBody Teacher teacher,
			@PathVariable Integer id) {
		try {
		Teacher existTeacher = service.get(id);
		service.save(teacher);
		
		return new ResponseEntity<>(HttpStatus.OK);
		}catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/teachers/{id}")
	public void delete(@PathVariable Integer id) {
		service.delete(id);
	}

}
