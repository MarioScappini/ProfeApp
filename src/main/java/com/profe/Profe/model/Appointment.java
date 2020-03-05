package com.profe.Profe.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.sql.Time;
import java.util.Date;
import java.util.UUID;

public class Appointment {
    @NotBlank
    private final UUID teacherId;
    @NotBlank
    private final UUID studentId;
    @NotBlank
    private final UUID lessonId;
    @NotBlank
    private final Date date;
    private final Date initialTime;
    private final Date finalTime;
    private final Float studentRating;
    @NotNull
    private final AppointmentStatus appointmentStatus;

    public Appointment(@JsonProperty("teacher_id") UUID teacherId,
                       @JsonProperty("student_id") UUID studentId,
                       @JsonProperty("lesson_id") UUID lessonId,
                       @JsonProperty("appointment_date") Date date,
                       @JsonProperty("student_rating") Float studentRating,
                       @JsonProperty("intial_time") Date initialTime,
                       @JsonProperty("final_time") Date finalTime,
                       @JsonProperty("status") AppointmentStatus appointmentStatus){
        this.teacherId = teacherId;
        this.studentId = studentId;
        this.lessonId = lessonId;
        this.date = date;
        this.studentRating = studentRating;
        this.initialTime = initialTime;
        this.finalTime = finalTime;
        this.appointmentStatus = appointmentStatus;
    }

    public UUID getTeacherId() {
        return teacherId;
    }

    public UUID getStudentId() {
        return studentId;
    }

    public UUID getLessonId() {
        return lessonId;
    }

    public Date getDate() {
        return date;
    }

    public Float getStudentRating() {
        return studentRating;
    }

    public Date getInitialTime() {
        return initialTime;
    }

    public Date getFinalTime() {
        return finalTime;
    }

    public AppointmentStatus getAppointmentStatus() {
        return appointmentStatus;
    }

    public enum AppointmentStatus {
        COMPLETED, SCHEDULED
    }
}
