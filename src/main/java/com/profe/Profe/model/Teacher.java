package com.profe.Profe.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotBlank;
import java.util.UUID;

public class Teacher {
    @NotBlank
    private final UUID teacherId;
    @NotBlank
    private final String firstName;
    @NotBlank
    private final String lastName;
    private final Float   rating;
    private final String  teacherDescription;
    private final String  nationality;
    private final String  currentResidence;
    private final String[] subject;



    public Teacher(@JsonProperty("teacher_id") UUID teacherId,
                   @JsonProperty("firstName") String firstName,
                   @JsonProperty("lastName") String lastName,
                   @JsonProperty("rating") Float rating,
                   @JsonProperty("teacher_description") String teacherDescription,
                   @JsonProperty("nationality") String nationality,
                   @JsonProperty("currentResidence") String currentResidence,
                   @JsonProperty("subject") String[] subject
                    ){
        this.teacherId = teacherId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.rating = rating;
        this.teacherDescription = teacherDescription;
        this.subject = subject;
        this.nationality = nationality;
        this.currentResidence = currentResidence;

    }

    public UUID getTeacherId() {
        return teacherId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Float getRating() {
        return rating;
    }

    public String getTeacherDescription() {
        return teacherDescription;
    }

    public String getNationality() {
        return nationality;
    }

    public String getCurrentResidence() {
        return currentResidence;
    }

    public String[] getSubject() {
        return subject;
    }

}
