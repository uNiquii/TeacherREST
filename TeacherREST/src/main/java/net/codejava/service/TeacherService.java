package net.codejava.service;

import java.util.List;

import net.codejava.model.Teacher;
import net.codejava.dao.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TeacherService {

	@Autowired
	private TeacherRepository repo;

	public List<Teacher> listAll(){
		return repo.findAll();
	}

	public void save(Teacher teacher) {
		repo.save(teacher);
	}

	public Teacher get(Integer id) {
		return repo.findById(id).get();
	}

	public void delete(Integer id) {
		repo.deleteById(id);
	}
}
