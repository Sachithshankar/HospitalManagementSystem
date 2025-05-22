package com.daada.hospitalmanagementmavenproject;

import com.daada.hospitalmanagementmavenproject.entity.Patient;
import com.daada.hospitalmanagementmavenproject.repository.PatientRepository;
import com.daada.hospitalmanagementmavenproject.service.PatientService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class PatientServiceTest {
    @Mock
    private PatientRepository patientRepository;

    @InjectMocks
    private PatientService patientService;

    private Patient samplePatient;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        samplePatient = new Patient(101, "Alice", "aabbcc", 990044, "1998-09-21");
    }

    @Test
    void testGetPatientById_Success() {
        when(patientRepository.findById(101)).thenReturn(Optional.of(samplePatient));

        Patient result = patientService.getPatientById(101);

        assertNotNull(result);
        assertEquals(samplePatient, result);
        verify(patientRepository, times(1)).findById(101);
    }

    @Test
    void testGetPatientById_NotFound() {
        when(patientRepository.findById(999)).thenReturn(Optional.empty());
        Patient result = patientService.getPatientById(999);
        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            patientService.getPatientById(999);
        });
        assertEquals("Patient not found", exception.getMessage());
    }

    @Test
    void testAddPatient() {
        when(patientRepository.save(samplePatient)).thenReturn(samplePatient);

        Patient result = patientService.createPatient(samplePatient);

        assertNotNull(result);
        assertEquals("Alice", result.getPatient_name());
        verify(patientRepository).save(samplePatient);
    }

    @Test
    void testDeletePatient() {
        doNothing().when(patientRepository).deleteById(101);

        patientService.deletePatientByID(101);

        verify(patientRepository, times(1)).deleteById(101);
    }
}
