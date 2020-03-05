package com.profe.Profe.service;

import com.profe.Profe.dao.StudentDataAccessService;
import com.profe.Profe.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentDataAccessService studentDataAccessService;

    public List<Student> getAllStudents(){
        return studentDataAccessService.selectAllStudents();
    }
}
