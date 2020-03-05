package com.profe.Profe.dao;

import com.profe.Profe.model.Lesson;
import com.profe.Profe.model.Student;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class LessonDataAccessService {
    JdbcTemplate jdbcTemplate;

    public List<Lesson> selectAllLessons(){
        String sql = "SELECT * FROM lesson";
        return jdbcTemplate.query(sql,mapLessonsFromDb());
    }

    public List<Lesson> selectLessonByTeacherId(UUID teacherId){
        String sql = "";
        return jdbcTemplate.query(sql,mapLessonsFromDb());
    }

    public RowMapper<Lesson> mapLessonsFromDb(){
        return (resultSet, i) -> {
            String lessonIdStr = resultSet.getString("lesson_id");
            UUID lessonId = UUID.fromString(lessonIdStr);

            String teacherIdStr = resultSet.getString("teacher_id");
            UUID teacherId = UUID.fromString(teacherIdStr);

            String lessonCostStr = resultSet.getString("lesson_cost");
            String durationStr = resultSet.getString("duration");

            String name = resultSet.getString("name");
            String description = resultSet.getString("description");

            try{
                Integer lessonCost = Integer.valueOf(lessonCostStr);
                Integer duration = Integer.valueOf(durationStr);

                return new Lesson(lessonId,teacherId,lessonCost,duration,name,description);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }

        };
    }
}
