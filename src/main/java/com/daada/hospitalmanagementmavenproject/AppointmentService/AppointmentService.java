package com.daada.hospitalmanagementmavenproject.AppointmentService;

import com.daada.hospitalmanagementmavenproject.Appointment.Appointment;
import com.daada.hospitalmanagementmavenproject.AppointmentRepository.AppointmentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;
    Logger log = LoggerFactory.getLogger(AppointmentService.class);

    public List<Appointment> getAllAppointment() {
        log.info("getting all the appointment");
        return appointmentRepository.findAll();
    }

    public Appointment getAppointment_id(int appointment_id) {
        log.info("getting Appointment with id " +  appointment_id);
        return appointmentRepository.findById(appointment_id).orElse(null);
    }

    public Appointment createAppointment(@RequestBody Appointment appointment) {
        log.info("creating the Appointment");
        return appointmentRepository.save(appointment);
    }

    public void deleteAppointment(int appointment_id) {
        log.warn("deleting the appointment with id " + appointment_id);
        appointmentRepository.deleteById(appointment_id);
    }
}
