package com.daada.hospitalmanagementmavenproject.service;

import com.daada.hospitalmanagementmavenproject.entity.Patient;
import com.daada.hospitalmanagementmavenproject.repository.PatientRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
@Service
public class PatientService {
    @Autowired
     final PatientRepository patientRepository;
    private static final Logger log = LoggerFactory.getLogger(PatientService.class);

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    public Patient getPatientById(int patient_id) {
        log.info("Getting patient with id {}", patient_id);
            return patientRepository.findById(patient_id).orElse(null);
    }

    public Patient createPatient(@RequestBody Patient patient){
        return patientRepository.save(patient);
    }

    public void deletePatientByID(int patient_id) {
        log.info("Deleting Patient with id {}" , patient_id);
        patientRepository.deleteById(patient_id);
    }
}
