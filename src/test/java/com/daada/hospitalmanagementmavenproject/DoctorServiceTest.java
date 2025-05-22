package com.daada.hospitalmanagementmavenproject;

import com.daada.hospitalmanagementmavenproject.Doctor.Doctor;
import com.daada.hospitalmanagementmavenproject.DoctorRepository.DoctorRepository;
import com.daada.hospitalmanagementmavenproject.DoctorService.DoctorService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.*;

public class DoctorServiceTest {
@Mock
    DoctorRepository doctorRepository;

@InjectMocks
DoctorService doctorService;

private Doctor sample;

Logger log = LoggerFactory.getLogger(DoctorServiceTest.class);

@BeforeEach
    void setUp() {
    MockitoAnnotations.openMocks(this);
    sample = new Doctor(101,"Dr. rishi", "kumar", "childrenspecialist", "Monday, Wednesday, Friday 9:00-17:00");
}

@Test
    void testcreateDoctors() {
        when(doctorRepository.save(sample)).thenReturn(sample);

        Doctor doctor =  doctorService.createDoctor(sample);
        assertEquals(doctor,sample);
        verify(doctorRepository).save(sample);
}

@Test
    void testgetDoctorById_IsSuccess() {
        when(doctorRepository.findById(101)).thenReturn(Optional.of(sample));

        Doctor findG = doctorService.findDoctorById(101);
        assertEquals(findG,sample);
        verify(doctorRepository,times(1)).findById(101);
}

@Test
    void testgetDoctorById_IsFail() {
        when(doctorRepository.findById(999)).thenReturn(Optional.empty());
        Doctor findF = doctorService.findDoctorById(999);
        assertNull(findF);
        log.error("The patient with id not found");
    }

    @Test
    void testDeleteDoctorById() {
        doNothing().when(doctorRepository).deleteById(101);
        doctorService.deleterDoctorById(101);
        verify(doctorRepository,times(1)).deleteById(101);
    }
}
