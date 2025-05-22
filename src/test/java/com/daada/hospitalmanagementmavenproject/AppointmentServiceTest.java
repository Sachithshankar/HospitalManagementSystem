package com.daada.hospitalmanagementmavenproject;

import com.daada.hospitalmanagementmavenproject.Appointment.Appointment;
import com.daada.hospitalmanagementmavenproject.AppointmentRepository.AppointmentRepository;
import com.daada.hospitalmanagementmavenproject.AppointmentService.AppointmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class AppointmentServiceTest {

    @Mock
    private AppointmentRepository appointmentRepository;

    @InjectMocks
    private AppointmentService appointmentService;

    private Appointment appointment;
    Logger log = LoggerFactory.getLogger(AppointmentServiceTest.class);

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        appointment = new Appointment(202, "2024-01-15 10:30:00", 2, 102, "Skin Rash", "Scheduled");
    }

    @Test
    void getAppointmentById_isValid() {
        when(appointmentRepository.findById(202)).thenReturn(Optional.of(appointment));

        Appointment newSample = appointmentService.getAppointment_id(202);
        assertEquals(appointment, newSample);
        verify(appointmentRepository, times(1)).findById(202);
    }

    @Test
    void getAppointmentById_isNotValid() {
        when(appointmentRepository.findById(999)).thenReturn(Optional.empty());
        Appointment sample = appointmentService.getAppointment_id(999);
        assertNull(sample);
        log.error("Patient not found with id " + 999);
    }

    @Test
    void testaddAppointments() {
        when(appointmentRepository.save(appointment)).thenReturn(appointment);
        Appointment sample = appointmentService.createAppointment(appointment);

        assertEquals(appointment, sample);
        verify(appointmentRepository, times(1)).save(appointment);
    }

    @Test
    void deleteAppointmentById_isValid() {
        doNothing().when(appointmentRepository).deleteById(202);
        appointmentService.deleteAppointment(202);
        verify(appointmentRepository, times(1)).deleteById(202);
    }


}
