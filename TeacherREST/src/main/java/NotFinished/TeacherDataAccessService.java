package NotFinished;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import net.codejava.model.Teacher;

import java.util.List;

@Repository
public class TeacherDataAccessService {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public TeacherDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    List<Teacher> selectAllTeachers() {
        String sql = "" +
                "SELECT " +
                " id, " +
                " first_name, " +
                " last_name, " +
                " email " +
                "FROM teacher";

        return jdbcTemplate.query(sql, mapTeacherFromDb());
    }

    int insertTeacher(int id, Teacher teacher) {
        String sql = "" +
                "INSERT INTO teacher (" +
                " id, " +
                " first_name, " +
                " last_name, " +
                " email, ";
        return jdbcTemplate.update(
                sql,
                id,
                teacher.getFirstName(),
                teacher.getLastName(),
                teacher.getEmail()
        );
    }

    @SuppressWarnings({ "ConstantConditions", "deprecation" })
    boolean isEmailTaken(String email) {
        String sql = "" +
                "SELECT EXISTS ( " +
                " SELECT 1 " +
                " FROM teacher " +
                " WHERE email = ?" +
                ")";
        return jdbcTemplate.queryForObject(
                sql,
                new Object[]{email},
                (resultSet, i) -> resultSet.getBoolean(1)
        );
    }



    private RowMapper<Teacher> mapTeacherFromDb() {
        return (resultSet, i) -> {
            String idStr = resultSet.getString("id");
            Integer id = Integer.parseInt(idStr);
            String nickName = resultSet.getString("nick_name");
            String firstName = resultSet.getString("first_name");
            String lastName = resultSet.getString("last_name");
            String password = resultSet.getString("password");
            String priceFloat = resultSet.getString("price");
            Float price = Float.parseFloat(priceFloat);
            String languages = resultSet.getString("languages");
            String email = resultSet.getString("email");

            return new Teacher(
                    id,
                    nickName,
                    firstName,
                    lastName,
                    password,
                    price,
                    languages,
                    email         
            );
        };
    }

    int updateEmail(int id, String email) {
        String sql = "" +
                "UPDATE teacher " +
                "SET email = ? " +
                "WHERE id = ?";
        return jdbcTemplate.update(sql, email, id);
    }

    int updateFirstName(int id, String firstName) {
        String sql = "" +
                "UPDATE teacher " +
                "SET first_name = ? " +
                "WHERE id = ?";
        return jdbcTemplate.update(sql, firstName, id);
    }

    int updateLastName(int id, String lastName) {
        String sql = "" +
                "UPDATE teacher " +
                "SET last_name = ? " +
                "WHERE id = ?";
        return jdbcTemplate.update(sql, lastName, id);
    }

    @SuppressWarnings({ "ConstantConditions", "deprecation" })
    boolean selectExistsEmail(int id, String email) {
        String sql = "" +
                "SELECT EXISTS ( " +
                "   SELECT 1 " +
                "   FROM teacher " +
                "   WHERE id <> ? " +
                "    AND email = ? " +
                ")";
        return jdbcTemplate.queryForObject(
                sql,
                new Object[]{id, email},
                (resultSet, columnIndex) -> resultSet.getBoolean(1)
        );
    }

    int deleteTeacherById(int id) {
        String sql = "" +
                "DELETE FROM teacher " +
                "WHERE id = ?";
        return jdbcTemplate.update(sql, id);
    }
}
