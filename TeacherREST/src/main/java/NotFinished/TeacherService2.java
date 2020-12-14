package NotFinished;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import NotFinished.exception.ApiRequestException;

import java.util.Optional;

import net.codejava.model.Teacher;


@Service
public class TeacherService2 {
	

	    private final TeacherDataAccessService teacherDataAccessService;
	    private final EmailValidator emailValidator;

	    @Autowired
	    public TeacherService2(TeacherDataAccessService teacherDataAccessService,
	                          EmailValidator emailValidator) {
	        this.teacherDataAccessService = teacherDataAccessService;
	        this.emailValidator = emailValidator;
	    }

	    public List<Teacher> getAllTeachers() {
	        return teacherDataAccessService.selectAllTeachers();
	    }

	    public void addNewTeacher(Teacher teacher) {
	        addNewTeacher(teacher);
	    }

	    void addNewStudent(Integer id, Teacher teacher) {

	        if (!emailValidator.test(teacher.getEmail())) {
	            throw new ApiRequestException(teacher.getEmail() + " is not valid");
	        }

	        if (teacherDataAccessService.isEmailTaken(teacher.getEmail())) {
	            throw new ApiRequestException(teacher.getEmail() + " is taken");
	        }

	        teacherDataAccessService.insertTeacher(id, teacher);
	    }


	    public void updateStudent(Integer id, Teacher teacher) {
	        Optional.ofNullable(teacher.getEmail())
	                .ifPresent(email -> {
	                    boolean taken = teacherDataAccessService.selectExistsEmail(id, email);
	                    if (!taken) {
	                    	teacherDataAccessService.updateEmail(id, email);
	                    } else {
	                        throw new IllegalStateException("Email already in use: " + teacher.getEmail());
	                    }
	                });

	        Optional.ofNullable(teacher.getFirstName())
	                .filter(firstName -> !StringUtils.isEmpty(firstName))
	                .map(StringUtils::capitalize)
	                .ifPresent(firstName -> teacherDataAccessService.updateFirstName(id, firstName));

	        Optional.ofNullable(teacher.getLastName())
	                .filter(lastName -> !StringUtils.isEmpty(lastName))
	                .map(StringUtils::capitalize)
	                .ifPresent(lastName -> teacherDataAccessService.updateLastName(id, lastName));
	    }

	    public void deleteTeacher(int id) {
	    	teacherDataAccessService.deleteTeacherById(id);
	    }
	}

