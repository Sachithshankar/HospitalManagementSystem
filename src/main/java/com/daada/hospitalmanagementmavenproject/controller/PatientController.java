package com.daada.hospitalmanagementmavenproject.controller;

import com.daada.hospitalmanagementmavenproject.entity.Patient;
import com.daada.hospitalmanagementmavenproject.service.PatientService;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patient")
public class PatientController {
    @Autowired
    private PatientService patientService;
    private static final Logger log = LoggerFactory.getLogger(PatientController.class);

    @GetMapping
    public List<Patient> getAllPatients() {
        log.info("Get all patients");
        return patientService.getAllPatients();
    }

    @GetMapping("/{patient_id}")
    public Patient getPatientById(@PathVariable int patient_id) {
        return patientService.getPatientById(patient_id);
    }

    @PostMapping
    public Patient addPatient(@RequestBody Patient patient) {
        return patientService.createPatient(patient);
    }

    @DeleteMapping("/{patient_id}")
    public void deletePatientById(@PathVariable int patient_id) {
        patientService.deletePatientByID(patient_id);
    }
}
