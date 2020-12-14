package NotFinished;

import java.util.List;

import net.codejava.model.Teacher;

public interface TeacherDAO {

	List<Teacher>list();
	
	Teacher getTeacherById(int id);
	
	void removeTeachertById(int id);
	
	void updateTeacher(int id);
	
	void insertTeacherToDb(Teacher teacher);
}
