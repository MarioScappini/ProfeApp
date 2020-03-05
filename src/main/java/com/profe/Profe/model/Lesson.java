package com.profe.Profe.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import java.util.UUID;

public class Lesson {
    @NotNull
    private final UUID lessonId;
    @NotNull
    private final UUID teacherId;
    @NotNull
    private final Integer lessonCost;
    @NotNull
    private final Integer duration;
    @NotNull
    private final String name;
    @NotNull
    private final String description;

    public Lesson(@JsonProperty("lesson_id") UUID lessonId,
                  @JsonProperty("teacher_id") UUID teacherId,
                  @JsonProperty("lesson_cost") Integer lessonCost,
                  @JsonProperty("duration") Integer duration,
                  @JsonProperty("name") String name,
                  @JsonProperty("description") String description) {
        this.lessonId = lessonId;
        this.teacherId = teacherId;
        this.lessonCost = lessonCost;
        this.duration = duration;
        this.name = name;
        this.description = description;
    }
    public UUID getLessonId() {
        return lessonId;
    }

    public UUID getTeacherId() {
        return teacherId;
    }

    public Integer getLessonCost() {
        return lessonCost;
    }

    public Integer getDuration() {
        return duration;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
