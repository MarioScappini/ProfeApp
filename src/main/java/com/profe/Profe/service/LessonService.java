package com.profe.Profe.service;

import com.profe.Profe.dao.AppointmentDataAccessService;
import com.profe.Profe.dao.LessonDataAccessService;
import com.profe.Profe.model.Lesson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LessonService {
    private LessonDataAccessService lessonDataAccessService;

    @Autowired
    public LessonService(LessonDataAccessService lessonDataAccessService){
        this.lessonDataAccessService = lessonDataAccessService;
    }

    public List<Lesson> getAllLessons(){
        return lessonDataAccessService.selectAllLessons();
    }

}
