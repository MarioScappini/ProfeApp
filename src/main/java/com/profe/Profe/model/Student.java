package com.profe.Profe.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

public class Student {
    private final UUID studentId;
    @NotBlank
    private final String firstName;
    @NotBlank
    private final String lastName;
    @NotBlank
    private final String email;
    private final String photoUrl;

    public Student(@JsonProperty("student_id") UUID studentId,
                   @JsonProperty("firstName") String firstName,
                   @JsonProperty("lastName") String lastName,
                   @JsonProperty("email") String email,
                   @JsonProperty("photo_url") String photoUrl) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.photoUrl = photoUrl;

    }

    public UUID getStudentId() {
        return studentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }
}
