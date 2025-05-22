package com.daada.hospitalmanagementmavenproject.AppointmentController;

import com.daada.hospitalmanagementmavenproject.Appointment.Appointment;
import com.daada.hospitalmanagementmavenproject.AppointmentService.AppointmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {
    @Autowired
    private AppointmentService appointmentService;

   private static final Logger log = LoggerFactory.getLogger(AppointmentController.class);
    @GetMapping
    public List<Appointment> getAllAppointments() {
        return appointmentService.getAllAppointment();
    }

    @GetMapping("/{appointment_id}")
    public Appointment getAppointmentById(@PathVariable int appointment_id) {
        log.info("getting the appointment with id {}" + appointment_id);
        return appointmentService.getAppointment_id(appointment_id);
    }

    @PostMapping
    public Appointment addAppointment(@RequestBody Appointment appointment) {
        log.info("adding the appointment with id {}" + appointment);
        return appointmentService.createAppointment(appointment);
    }

    @DeleteMapping("/{appointment_id}")
    public void deleteAppointmentById(@PathVariable int appointment_id) {
        log.warn("deleting the appointment with id {}" + appointment_id);
        appointmentService.deleteAppointment(appointment_id);
    }
}
