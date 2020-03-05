package com.profe.Profe.controller;

import com.profe.Profe.model.Appointment;
import com.profe.Profe.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @GetMapping
    public List<Appointment> getAllAppointments(){
        return appointmentService.getAppointmets();
    }

    @GetMapping(path = "{studentId}")
    public List<Appointment> getAppointmentsById(@PathVariable("studentId") UUID studentId){
        return  null;
    }

    @PostMapping
    public void createAppointment(@RequestBody Appointment appointment){

    }


}
