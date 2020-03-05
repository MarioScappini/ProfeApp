package com.profe.Profe.service;

import com.profe.Profe.dao.TeachersDataAccessService;
import com.profe.Profe.exceptions.InvalidFieldException;
import com.profe.Profe.model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TeachersService {
    private final TeachersDataAccessService teachersDataAccessService;

    @Autowired
    public TeachersService(TeachersDataAccessService teachersDataAccessService) {
        this.teachersDataAccessService = teachersDataAccessService;
    }

    public List<Teacher> getAllTeachers(){
        return teachersDataAccessService.selectAllTeachers();
    }

    public void addNewteacher(Teacher teacher){
        addNewteacher(null,teacher);
    }
    void addNewteacher(UUID teacherId, Teacher teacher){
        UUID newTeacherId = UUID.randomUUID();
        if(teacher.getFirstName() == null || teacher.getLastName() == null){
          throw new InvalidFieldException("First Name & Last Name are required");
        }
        teachersDataAccessService.insertTeacher(newTeacherId, teacher);
    }
}
