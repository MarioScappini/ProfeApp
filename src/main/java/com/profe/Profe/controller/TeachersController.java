package com.profe.Profe.controller;


import com.profe.Profe.model.Teacher;
import com.profe.Profe.service.TeachersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api/teacher")
public class TeachersController {
    private TeachersService teachersService;

    @Autowired
    public TeachersController(TeachersService teachersService) {
        this.teachersService = teachersService;
    }

    @GetMapping
    public List<Teacher> getTeachersList(){
        return teachersService.getAllTeachers();
    }

    @PostMapping
    public void addNewTeacher(@RequestBody Teacher teacher){
        teachersService.addNewteacher(teacher);
    }

}
