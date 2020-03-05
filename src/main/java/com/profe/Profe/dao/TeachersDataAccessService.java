package com.profe.Profe.dao;

import com.profe.Profe.model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.Array;
import java.util.List;
import java.util.UUID;

@Repository
public class TeachersDataAccessService {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public TeachersDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Teacher> selectAllTeachers(){
        final String sql = "SELECT * FROM teacher ";
        return jdbcTemplate.query(sql,mapTeacherFromDb());
    }

    public int insertTeacher(UUID teacherId,Teacher teacher){

        String sql = "INSERT INTO teacher(teacher_id,firstname,lastname," +
                "teacher_description,nationality,currentresidence) VALUES(?,?,?,?,?,?)";
        return jdbcTemplate.update(sql,
                teacherId,
                teacher.getFirstName(),
                teacher.getLastName(),
                teacher.getTeacherDescription(),
                teacher.getNationality(),
                teacher.getCurrentResidence());
    }
    private RowMapper<Teacher> mapTeacherFromDb(){
        return (resultSet, i) -> {
            String teacherIdStr = resultSet.getString("teacher_id");
            UUID teacherId = UUID.fromString(teacherIdStr);

            String firstName = stringFormat(resultSet.getString("firstname"));
            String lastName = stringFormat(resultSet.getString("lastname"));
            Array subjectStdArray = resultSet.getArray("subject");
            String[] subjectArray = null;
            if (subjectStdArray != null){ subjectArray = (String[])subjectStdArray.getArray();}

            Float rating = null;
            if (resultSet.getString("rating") != null){ rating = Float.valueOf(resultSet.getString("rating"));}
            String teacherDescription = stringFormat(resultSet.getString("teacher_description"));
            String nationality = stringFormat(resultSet.getString("nationality"));
            String currentResidence = stringFormat(resultSet.getString("currentResidence"));
            return new Teacher(teacherId,firstName,lastName,rating,teacherDescription,nationality,currentResidence,subjectArray);

        };
    }
    public String stringFormat(String stringToFormat) {
        if(stringToFormat == null){
            return null;
        }
        String lowerCaseString = stringToFormat.toLowerCase();
        String finalString = lowerCaseString.substring(0,1).toUpperCase() + lowerCaseString.substring(1);
        return finalString;
    }

}
