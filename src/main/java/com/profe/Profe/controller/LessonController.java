package com.profe.Profe.controller;

import com.profe.Profe.model.Lesson;
import com.profe.Profe.service.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/lesson")
public class LessonController {
    private LessonService lessonService;

    @Autowired
    public LessonController(LessonService lessonService){
        this.lessonService = lessonService;
    }

    @GetMapping
    public List<Lesson> getAllLessons(){
        return lessonService.getAllLessons();
    }

}
