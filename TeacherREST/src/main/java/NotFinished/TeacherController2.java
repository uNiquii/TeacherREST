package NotFinished;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import net.codejava.model.Teacher;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/teachers")
public class TeacherController2 {

    private final TeacherService2 teacherService;

    @Autowired
    public TeacherController2(TeacherService2 teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping
    public List<Teacher> getAllTeachers() {
        return teacherService.getAllTeachers();
    }


    @PostMapping
    public void addNewStudent(@RequestBody @Valid Teacher teacher) {
    	teacherService.addNewTeacher(teacher);
    }

    @PutMapping(path = "{id}")
    public void updateStudent(@PathVariable("id") Integer id,
                              @RequestBody Teacher teacher) {
    	teacherService.updateStudent(id, teacher);
    }

    @DeleteMapping("{id}")
    public void deleteTeacher(@PathVariable("id") Integer id) {
    	teacherService.deleteTeacher(id);
    }
}
