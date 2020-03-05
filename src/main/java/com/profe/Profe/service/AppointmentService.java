package com.profe.Profe.service;

import com.profe.Profe.dao.AppointmentDataAccessService;
import com.profe.Profe.model.Appointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentDataAccessService appointmentDataAccessService;

    public List<Appointment> getAppointmets(){
        return appointmentDataAccessService.selectAllAppointments();
    }
}
