package NotFinished;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import net.codejava.model.Teacher;

@Repository
@Qualifier("TeacherDAO")
public class TeacherDaoImpl implements TeacherDAO {
	
	@Override
	public List<Teacher>list(){
		return new ArrayList<Teacher>() {

		{
			add(new Teacher(1,"uNi", "Patrik", "Gelnar", "sssss", 20000, "CZ", "test@test"));
		}
		};
	}
	
	@Override
	public Teacher getTeacherById(int id) {
		return null;
	}
	@Override
	public void removeTeachertById(int id) {
	}
	@Override
	public void updateTeacher(int id) {
	}
	@Override
	public void insertTeacherToDb(Teacher teacher) {
	}
	
}
