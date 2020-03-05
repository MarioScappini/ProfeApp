package com.profe.Profe.dao;

import com.profe.Profe.model.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class StudentDataAccessService {
    private JdbcTemplate jdbcTemplate;

    public List<Student> selectAllStudents(){
        String sql = "SELECT * FROM student";
        return jdbcTemplate.query(sql,mapStudentFromDb());
    }

    public RowMapper<Student> mapStudentFromDb(){
        return (resultSet, i) -> {
            String studentIdStr = resultSet.getString("studernt_id");
            UUID studentId = UUID.fromString(studentIdStr);
            String firstName = resultSet.getString("firstName");
            String lastName = resultSet.getString("lastName");
            String email = resultSet.getString("email");
            String photoUrl = resultSet.getString("photo_url");
            return new Student(studentId,firstName,lastName,email,photoUrl);
        };
    }
}
