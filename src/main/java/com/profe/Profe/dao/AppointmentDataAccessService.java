package com.profe.Profe.dao;

import com.profe.Profe.model.Appointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Repository
public class AppointmentDataAccessService {

    @Autowired
    private  JdbcTemplate jdbcTemplate;


    public List<Appointment> selectAllAppointments(){
        String sql = "SELECT * FROM appointment";
        return jdbcTemplate.query(sql,mapAppointmentFromDb());
    }


    private RowMapper<Appointment> mapAppointmentFromDb(){
        return (resultSet, i) -> {
            String teacherIdStr = resultSet.getString("teacher_id");
            UUID teacherId = UUID.fromString(teacherIdStr);

            String studentIdStr = resultSet.getString("student_id");
            UUID studentId = UUID.fromString(studentIdStr);

            String lessonIdStr = resultSet.getString("lesson_id");
            UUID lessonId = UUID.fromString(lessonIdStr);

            String studentRatingStr = resultSet.getString("student_id");
            String appointmentDateStr = resultSet.getString("appointment_date");
            String initialTimeStr = resultSet.getString("initial_time");
            String finalTimeStr = resultSet.getString("final_time");
            String status = resultSet.getString("status").toUpperCase();
            try {
                Date appointmentDate = new SimpleDateFormat("dd/MM/yyyy").parse(appointmentDateStr);
                Date initialTime = new SimpleDateFormat("hh:mm").parse(initialTimeStr);
                Date finalTime = new SimpleDateFormat("hh:mm").parse(finalTimeStr);
                Float studentRating = Float.parseFloat(studentRatingStr);
                Appointment.AppointmentStatus appointmentStatus = Appointment.AppointmentStatus.valueOf(status);

                return new Appointment(
                        teacherId,
                        studentId,
                        lessonId,
                        appointmentDate,
                        studentRating,
                        initialTime,
                        finalTime,
                        appointmentStatus);
            } catch (ParseException e) {
                e.printStackTrace();
                return null;
            }
        };
    }

}
